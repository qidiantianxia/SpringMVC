package com.jike.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BetweenValidator implements ConstraintValidator<BetweenAnnotation, Integer> {
	int min;
	int max;

	@Override
	public void initialize(BetweenAnnotation constraintAnnotation) {
		min = constraintAnnotation.min();
		max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value != null && (value > min && value < max)) {
			return true;
		}

		return false;
	}

}
