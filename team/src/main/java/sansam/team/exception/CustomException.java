package sansam.team.exception;

import lombok.Getter;

@Getter
public class CustomException extends Exception {
    ErrorCodeType errorCode;

    public CustomException(ErrorCodeType errorCode) {
        this.errorCode = errorCode;
    }
}
