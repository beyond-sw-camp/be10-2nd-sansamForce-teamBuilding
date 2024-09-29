package sansam.team.exception;

import lombok.Getter;

@Getter
public class CustomNotFoundException extends RuntimeException {

    ErrorCodeType errorCode;

    public CustomNotFoundException(ErrorCodeType errorCode) {
        this.errorCode = errorCode;
    }

}
