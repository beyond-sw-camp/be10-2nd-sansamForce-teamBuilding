package com.sansam.project.exception;


import com.sansam.project.common.response.ApiResponse;
import com.sansam.project.common.response.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 로거 설정
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 커스텀 예외 처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<String>> handleCustomNotFoundException(CustomException e) {
        // 예외 메시지 로깅
        logger.error("CustomException occurred: {}", e.getMessage(), e);

        return ResponseUtil.failureResponse(e.getErrorCode().getMessage(), e.getErrorCode().getCode(), e.getErrorCode().getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleCustomNotFoundException(RuntimeException e) {
        // 예외 메시지 로깅
        logger.error("CustomException occurred: {}", e.getMessage(), e);

        return ResponseUtil.failureResponse(e.getMessage(), null);
    }

    // 데이터베이스 관련 예외 처리
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ApiResponse<String>> handleDataAccessException(DataAccessException e) {
        // 예외 메시지와 스택 트레이스 로깅
        logger.error("DataAccessException occurred: {}", e.getMessage(), e);

        return ResponseUtil.failureResponse("Database error occurred: " + e.getMessage(), "DB_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 유효성 검증 실패 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleValidationException(MethodArgumentNotValidException e) {
        // 유효성 검증 실패 상세 정보 로깅
        String errorMessage = e.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        logger.error("Validation error occurred: {}", errorMessage);

        return ResponseUtil.failureResponse("Validation error: " + errorMessage, "VALIDATION_ERROR", HttpStatus.BAD_REQUEST);
    }

    // 권한 관련 예외 처리
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse<String>> handleAccessDeniedException(AccessDeniedException e) {
        // 예외 메시지와 스택 트레이스 로깅
        logger.warn("AccessDeniedException occurred: {}", e.getMessage());

        return ResponseUtil.failureResponse("Access denied: " + e.getMessage(), "ACCESS_DENIED", HttpStatus.FORBIDDEN);
    }

    // 기타 모든 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception e) {
        // 예외 메시지와 스택 트레이스 로깅
        logger.error("Unexpected error occurred: {}", e.getMessage(), e);

        return ResponseUtil.exceptionResponse(e, "INTERNAL_ERROR");
    }
}