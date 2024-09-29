package sansam.team.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeType {
    // user 관련 오류
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_ERROR_001", "사용자를 찾을 수 없습니다."),
    USER_DUPLICATED(HttpStatus.BAD_REQUEST, "USER_ERROR_002", "중복된 사용자입니다."),
    USER_LOGIN_NOT_FOUND(HttpStatus.BAD_REQUEST, "USER_ERROR_003", "아이디 또는 비밀번호가 일치하지 않습니다."),


    //team 관련 오류
    TEAM_NOT_FOUND(HttpStatus.NOT_FOUND, "TEAM_ERROR_001", "팀을 찾을 수 없습니다."),

    //team member 관련 오류
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_ERROR_001", "팀원을 찾을 수 없습니다."),

    //team review 관련 오류
    REVIEW_CREATE_ERROR(HttpStatus.BAD_REQUEST, "REVIEW_ERROR_001", "팀원 평가를 생성할 수 없습니다."),
    REVIEW_CREATE_TIME_ERROR(HttpStatus.BAD_REQUEST, "REVIEW_ERROR_002", "팀원 평가 기간이 아닙니다."),
    REVIEW_NOT_FOUND(HttpStatus.BAD_REQUEST, "REVIEW_ERROR_003", "해당 리뷰를 찾을 수 없습니다."),
    REVIEW_DELETE_ERROR(HttpStatus.BAD_REQUEST, "REVIEW_ERROR_004", "해당 리뷰를 삭제할 수 없습니다."),

    // 공통 오류
    COMMON_ERROR(HttpStatus.BAD_REQUEST, "COMMON_ERROR", "오류가 발생하였습니다. 관리자에게 문의 바랍니다.")

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
