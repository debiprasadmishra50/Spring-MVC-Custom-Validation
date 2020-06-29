package demo.mvc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	// <Our annotation, Type of data we are validating against>
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		// isValid(HTML Form Data entered by user, Helper class for additional error message)
		
		boolean result;
		
		if (theCode != null) // if entered data != null, check if theCode.startsWith(courseprefix)
			result = theCode.startsWith(coursePrefix);
		else // if nothing entered, simply return true
			result = true;

		return result;
	}
	
}
