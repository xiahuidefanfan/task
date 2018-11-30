package com.team.tool.task.common.aop;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.team.tool.task.common.enums.ErrorCodeEnum;
import com.team.tool.task.common.exception.SystemException;
import com.team.tool.task.common.util.ToolUtil;

import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: ControllerValidatorInterceptor.java
 * @Description: 校验统一处理切面
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月27日 下午6:51:55 
 *
 * Modification History:
 * Date           Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月27日     xiahui           v1.0.0         校验统一处理切面
 */
@Aspect
@Component
public class ControllerValidatorInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerValidatorInterceptor.class);
	
	@Around("execution(* com.team.tool.task..*.*(..)) && args(..,bindingResult)")
    public Object doAround(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable {
        if (bindingResult.hasErrors()) {
        	List<FieldError> fieldErrors = bindingResult.getFieldErrors();
      	   	String validMess = "";
      	   	for(FieldError fieldError : fieldErrors) {
      	   		if(ToolUtil.isNotEmpty(validMess)) {
      	   			validMess += "，" + fieldError.getDefaultMessage();
      	   		}else {
      	   			validMess += fieldError.getDefaultMessage();
      	   		}
      	   	 }
      	   	throw new SystemException(ErrorCodeEnum.CHECK_ERROR, getOperateName(pjp), validMess);
        } else {
        	return pjp.proceed();
        }
    }
	
	/**
	 * @Description: 获取方法的操作名称
	 * @author: xiahui
	 * @return: String  操作名称
	 * @date: 2018年11月28日 上午9:49:28
	 */
	private String getOperateName(ProceedingJoinPoint pjp) {
		MethodSignature msig = (MethodSignature)pjp.getSignature();
		try{
			Object target = pjp.getTarget();
	        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
	        ApiOperation apiOperation = currentMethod.getAnnotation(ApiOperation.class);
	        String operateName = apiOperation.value();
	        return operateName;
		}catch(Exception e) {
			LOGGER.warn("方法：{}未获取操作名称！", msig.getName());
			return "未知操作";
		}
        
	}
}
