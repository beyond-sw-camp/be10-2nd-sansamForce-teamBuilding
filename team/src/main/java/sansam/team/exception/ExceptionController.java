package sansam.team.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import sansam.team.exception.aggregate.UserException;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> handleUserRegistException(
            UserException e
    ) {

        String code = "ERROR_001";
        String message = "회원 정보 조회 실패";

        return new ResponseEntity<>(
                new ErrorResponse(code, message), HttpStatus.NOT_FOUND
        );

    }

}
