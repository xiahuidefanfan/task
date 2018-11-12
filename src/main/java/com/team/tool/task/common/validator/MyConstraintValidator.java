package com.team.tool.task.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhailiang
 *
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
