package com.example.boot.exeptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiException> notFound() {
        return new ResponseEntity<>(ApiException.builder().code(ErrorCodeEnum.NOT_FOUND).message("Not found").build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiException> notValid() {
        return new ResponseEntity<>(ApiException.builder().code(ErrorCodeEnum.NOT_VALID).message("Not valid").build(), HttpStatus.BAD_REQUEST);
    }

}
