package com.team.tool.task.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName: MyConstraintValidator.java
 * @Description: 自定义注解校验规则
 *
 * @version: v1.0.0
 * @author: xiahui
 * @date: 2018年11月23日 上午10:12:37 
 *
 * Modification History:
 * Date         Author          Version            Description
 *-------------------------------------------------------------*
 * 2018年11月23日     xiahui           v1.0.0         自定义注解校验规则
 */

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		System.out.println("my validator init");
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		return true;
	}

}
