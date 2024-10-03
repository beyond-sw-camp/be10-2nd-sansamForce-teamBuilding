package com.sansam.team.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    ErrorCodeType errorCode;

    public CustomException(ErrorCodeType errorCode) {
        this.errorCode = errorCode;
    }

}
