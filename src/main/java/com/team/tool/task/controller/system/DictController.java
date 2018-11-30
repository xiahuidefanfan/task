package com.team.tool.task.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.tool.task.common.support.RespData;
import com.team.tool.task.service.system.SystemDictService;

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
