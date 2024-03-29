package com.example.boot.common.validator;

import com.example.boot.author.entity.Author;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckAuthorNameContainsXxxImpl implements ConstraintValidator<CheckAuthorNameContainsXxx, Author> {

    @Override
    public boolean isValid(Author author, ConstraintValidatorContext context) {
        return !author.getName().equalsIgnoreCase("xxx");
    }
}
