package com.authAngular.tutorial.authAngular.api.controllers;

import com.authAngular.tutorial.authAngular.dto.ErrorDto;
import com.authAngular.tutorial.authAngular.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException (AppException ex){
        return ResponseEntity.status(ex.getHttpStatus()).body(
                new ErrorDto(ex.getMessage())
        );
    }
}
