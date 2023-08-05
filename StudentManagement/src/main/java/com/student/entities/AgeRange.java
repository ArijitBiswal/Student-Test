package com.student.entities;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AgeRangeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AgeRange {

    String message() default "Age must be greater than 15 and less than or equal to 20";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


