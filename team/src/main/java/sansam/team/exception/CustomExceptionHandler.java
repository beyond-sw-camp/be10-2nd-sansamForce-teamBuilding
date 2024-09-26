package sansam.team.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

   @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ErrorResponseEntity> handle(CustomException e) {
       return ErrorResponseEntity.toResponseEntity(e.getErrorCode());
   }

}
