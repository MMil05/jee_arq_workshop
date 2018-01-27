package com.infoshareacademy.searchengine.domain;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = FirstLetterAValidator.class)
//This constraint annotation can be used only on fields and method parameters.
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface FirstLetterA {

    String message() default "Invalid first letter, it should be A";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}