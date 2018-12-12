package com.team.tool.task.common.aop;

import java.sql.SQLException;

import org.apache.ibatis.ognl.NoSuchPropertyException;
import org.apache.ibatis.reflection.ReflectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.baomidou.mybatisplus.exceptions.MybatisPlusException;
import com.team.tool.task.common.support.RespData;

/**
 * @ClassName: GlobalExceptionHandler.java
 * @Description: 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月26日 下午6:21:16 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月26日     xiahui           v1.0.0           异常拦截器
 */
@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * sql错误
     */
    @ExceptionHandler({SQLException.class, MybatisPlusException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespData sqlExceptionHandler(Exception e) {
    	LOGGER.error("数据库操作异常，异常信息为：{}", e.getMessage());
    	return RespData.getRespData(true, null, "系统异常，请联系技术人员！");
    }
    
    /**
     * 空指针错误
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespData nullPointerException(NullPointerException e) {
    	LOGGER.error("控制针异常，异常信息为：{}", e.getMessage());
    	return RespData.getRespData(true, null, "系统异常，请联系技术人员！");
    }
    
    /**
     * 反射错误
     */
    @ExceptionHandler(ReflectionException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespData reflectionException(ReflectionException e) {
    	LOGGER.error("反射异常，异常信息为：{}", e.getMessage());
    	return RespData.getRespData(true, null, "系统异常，请联系技术人员！");
    }
    
    /**
     * 属性错误
     */
    @ExceptionHandler(NoSuchPropertyException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespData noSuchPropertyException(NoSuchPropertyException e) {
    	LOGGER.error("属性异常，异常信息为：{}", e.getMessage());
    	return RespData.getRespData(true, null, "系统异常，请联系技术人员！");
    }
    
}
