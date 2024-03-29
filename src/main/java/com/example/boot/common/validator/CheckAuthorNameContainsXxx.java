package com.example.boot.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = CheckAuthorNameContainsXxxImpl.class)
@Documented
public @interface CheckAuthorNameContainsXxx {
    String message() default "Author name has invalid text";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
