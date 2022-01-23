package com.api.examplecrudrest.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ExampleCrudRestException.class})
    public ResponseEntity<ErrorResponse> businessException(ExampleCrudRestException e) {
        return ResponseEntity
                .status(e.getErrorCodeDescription().getStatus())
                .body(new ErrorResponse(e.getErrorCodeDescription()));
    }
}
