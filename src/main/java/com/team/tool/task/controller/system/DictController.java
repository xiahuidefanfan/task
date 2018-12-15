package com.team.tool.task.controller.system;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.team.tool.task.bean.condition.system.SystemDictQueryCondition;
import com.team.tool.task.bean.dto.security.SecurityUser;
import com.team.tool.task.bean.model.system.SystemDict;
import com.team.tool.task.common.support.RespData;
import com.team.tool.task.common.support.SecuritySupport;
import com.team.tool.task.service.system.SystemDictService;
import com.team.tool.task.warpper.system.SystemDictWarpper;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: DictController.java
 * @Description: 字典控制器
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月26日 下午3:32:18 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月26日     xiahui           v1.0.0       字典控制器
 */
@RestController
@RequestMapping("/dict")
public class DictController {
	
	@Autowired
	private SystemDictService systemDictService;
	
	/**
	 * @Description: 字典列表查询
	 * @author: xiahui
	 * @date: 2018年12月1日 下午2:52:37
	 */
    @SuppressWarnings("unchecked")
	@PostMapping(value = "/list.action")
    @ApiOperation(value = "字典列表查询")
    public RespData list(SystemDictQueryCondition condition) {
        Page<SystemDict> page = new Page<SystemDict>(condition.getPageNumber(), condition.getPageSize());
        List<Map<String, Object>> roleList = this.systemDictService.queryParentDictList(page, condition);
        page.setRecords((List<SystemDict>) new SystemDictWarpper(roleList).warp());
        return RespData.getRespData(true, page.getRecords(), "", page.getTotal());
    }
    
    /**
     * @Description: 添加字典
     * @author: xiahui
     * @date: 2018年12月1日 下午4:31:00
     */
    @PostMapping(value = "/add.action")
    @ApiOperation(value = "添加字典")
    public RespData add(@Valid SystemDict dict, BindingResult bindingResult) {
    	/**
    	 * 设置字典基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	dict.setCreator(securityUser.getUserId());
    	dict.setUpdator(securityUser.getUserId());
    	dict.setCreateTime(new Timestamp(System.currentTimeMillis()));
    	dict.setUpdateTime(new Timestamp(System.currentTimeMillis()));
    	
    	/**
    	 * 保存字典信息
    	 */
    	dict.insert();
        return RespData.getRespData(true, null, "添加字典成功！");
    }
    
    /**
     * @Description: 修改字典
     * @author: xiahui
     * @date: 2018年12月1日 下午4:32:34
     */
    @PutMapping(value = "/update.action")
    @ApiOperation(value = "修改字典")
    public RespData update(@Valid SystemDict dict, BindingResult bindingResult) {
    	/**
    	 * 设置字典基础信息
    	 */
    	SecurityUser securityUser = SecuritySupport.getSecurityUser();
    	dict.setUpdator(securityUser.getUserId());
    	
    	/**
    	 * 保存字典信息
    	 */
    	dict.updateById();
        return RespData.getRespData(true, null, "修改字典成功！");
    }
    
	/**
	 * @Description: 根据父级字典编码查询子级字典
	 * @author xiahui
	 * @date 2018年11月26日 下午4:26:31
	 */
    @PostMapping(value = "/queryDictByParentCode.action")
    @ApiOperation(value = "根据父级字典编码查询子级字典")
    public RespData queryDictByParentCode(@RequestParam String code) {
        List<Map<String, Object>> dictList = this.systemDictService.queryDictByParentCode(code);
        return RespData.getRespData(true, dictList, "");
    }
}
