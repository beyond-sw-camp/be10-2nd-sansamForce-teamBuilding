package sansam.team.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeType {
    // user 관련 오류
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER_ERROR_001", "사용자를 찾을 수 없습니다."),
    USER_DUPLICATED(HttpStatus.BAD_REQUEST, "USER_ERROR_002", "중복된 사용자입니다."),

    // 공통 오류
    COMMON_ERROR(HttpStatus.BAD_REQUEST, "COMMON_ERROR", "오류가 발생하였습니다. 관리자에게 문의 바랍니다.")

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
