package com.team.tool.task.common.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.team.tool.task.common.exception.SystemException;
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
@Order(1)
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统错误
     */
    @ExceptionHandler(SystemException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespData systemExceptionHandler(SystemException e) {
    	LOGGER.error(e.getMessage());
        return RespData.getRespData(true, null, e.getMessage());
    }
    
}
