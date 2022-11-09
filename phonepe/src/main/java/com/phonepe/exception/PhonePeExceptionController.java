package com.phonepe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhonePeExceptionController {

    @ExceptionHandler
    public ResponseEntity<Object> exception(Error error) {
	return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
    }
}