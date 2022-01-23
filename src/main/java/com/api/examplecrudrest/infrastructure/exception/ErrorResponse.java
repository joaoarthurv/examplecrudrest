package com.api.examplecrudrest.infrastructure.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;

    public ErrorResponse(ErrorCodeDescription errorCodeDescription) {
        this.errorCode = errorCodeDescription.getErrorCode();
        this.errorMessage = errorCodeDescription.getErrorMessage();
    }
}
