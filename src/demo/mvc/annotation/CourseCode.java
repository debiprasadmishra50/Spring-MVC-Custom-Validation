package demo.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // validateBy the helper class which contains your business logic
@Target( {ElementType.METHOD, ElementType.FIELD} ) // Where can you apply this annotation
@Retention(RetentionPolicy.RUNTIME) // How long should we retain it, here it means keep the annotation in compiled java bytecode so we can use it, introspect on it, and instrument on it during runtime
public @interface CourseCode {
	
	// define default course code
	public String value() default "JAVA";
	
	// define default error message
	public String message() default "must start with JAVA";
	
	// define default groups
	public Class<?>[] groups() default {}; // can group related constraints
	
	// define default payload
	public Class<? extends Payload>[] payload() default {}; // Payload provide custom details about validation failure 
	
}
