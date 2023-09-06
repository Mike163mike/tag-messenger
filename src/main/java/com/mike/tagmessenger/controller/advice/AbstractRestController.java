package com.mike.tagmessenger.controller.advice;

import com.mike.tagmessenger.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AbstractRestController {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<Object> exceptionHandler(AppException e) {
        return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
}
