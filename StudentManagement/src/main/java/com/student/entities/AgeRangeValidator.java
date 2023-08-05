package com.student.entities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeRangeValidator implements ConstraintValidator<AgeRange, LocalDate> {

    @Override
    public void initialize(AgeRange constraintAnnotation) {
        // No initialization needed
    }

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext context) {
        if (dob == null) {
            return true; // Let @NotBlank and @Past handle null values
        }

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dob, currentDate);

        return period.getYears() > 15 && period.getYears() <= 20;
    }
}
