package com.example.Marketplace;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//With the @Constraint annotation, we defined the class
// that is going to validate our field.
// The message() is the error message
// that is showed in the user interface. Finally, the additional
// code is mostly boilerplate code to conform to the Spring standards.
@Documented
@Constraint(validatedBy = NumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberConstraint {
    String message() default "This phone number has already been registered";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
