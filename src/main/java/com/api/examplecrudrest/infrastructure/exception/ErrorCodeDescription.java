package com.api.examplecrudrest.infrastructure.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCodeDescription {
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "API_ERROR_001", "Internal Server Error"),
    BAD_REQUEST_FOR_CREATE_USER(HttpStatus.BAD_REQUEST.value(), "API_ERROR_002", "Could not create user"),
    NOT_FOUND_USER(HttpStatus.NOT_FOUND.value(), "API_ERROR_003", "Could not find user"),
    NOT_FOUND_PERSON(HttpStatus.NOT_FOUND.value(), "API_ERROR_004", "Could not find person"),
    BAD_REQUEST_FOR_DELETE_USER(HttpStatus.BAD_REQUEST.value(), "API_ERROR_005", "Could not delete user"),
    BAD_REQUEST_FOR_UPDATE_USER(HttpStatus.BAD_REQUEST.value(), "API_ERROR_006", "Could not update user"),
    BAD_REQUEST_FOR_UPDATE_PERSON(HttpStatus.BAD_REQUEST.value(), "API_ERROR_007", "Could not update person");


    private final int status;
    private final String errorCode;
    private final String errorMessage;
}
