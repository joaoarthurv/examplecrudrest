package com.api.examplecrudrest.infrastructure.exception;

import lombok.Getter;

@Getter
public class ExampleCrudRestException extends RuntimeException{
    private ErrorCodeDescription errorCodeDescription;

    public ExampleCrudRestException(ErrorCodeDescription errorCodeDescription){
        this.errorCodeDescription = errorCodeDescription;
    }
}
