package sansam.team.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeType {

    // 스프링 시큐리티 관련 오류
    SECURITY_ACCESS_ERROR(HttpStatus.BAD_REQUEST, "SECURITY_ERROR_001", "접근 권한이 없습니다."),
    SECURITY_TOKEN_ERROR(HttpStatus.BAD_REQUEST, "SECURITY_ERROR_002", "로그인 후 다시 시도해 주세요."),
    SECURITY_LOGIN_ERROR(HttpStatus.BAD_REQUEST, "SECURITY_ERROR_003", "로그인 실패하였습니다. 관리자에게 문의해 주세요."),

    // user 관련 오류
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_ERROR_001", "사용자를 찾을 수 없습니다."),
    USER_DUPLICATED(HttpStatus.BAD_REQUEST, "USER_ERROR_002", "중복된 사용자입니다."),
    USER_LOGIN_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_ERROR_003", "아이디 또는 비밀번호가 일치하지 않습니다."),
    MENTOR_AUTH_ERROR(HttpStatus.BAD_REQUEST, "USER_ERROR_004", "해당 기능은 멘토만 가능합니다."),


    //team 관련 오류
    TEAM_NOT_FOUND(HttpStatus.NOT_FOUND, "TEAM_ERROR_001", "팀을 찾을 수 없습니다."),
    TEAM_STATUS_ERROR(HttpStatus.BAD_REQUEST, "TEAM_ERROR_002", "팀 상태를 확인해 주세요."),
    TEAM_END_ERROR(HttpStatus.BAD_REQUEST, "TEAM_ERROR_003", "이미 종료된 팀 입니다."),

    //team member 관련 오류
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_ERROR_001", "팀원을 찾을 수 없습니다."),

    //team schedule 관련 오류
    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "SCHEDULE_ERROR_001", "해당 일정을 찾을 수 없습니다."),
    SCHEDULE_PERIOD_ERROR(HttpStatus.BAD_REQUEST, "SCHEDULE_ERROR_002", "팀 일정 기간을 확인해주세요."),

    //team member schedule 관련 오류
    MEMBER_SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER_SCHEDULE_ERROR_001", "해당 팀원의 진행 일정을 찾을 수 없습니다."),

    //team review 관련 오류
    REVIEW_CREATE_TIME_ERROR(HttpStatus.BAD_REQUEST, "REVIEW_ERROR_001", "팀원 평가 기간이 아닙니다."),
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "REVIEW_ERROR_002", "해당 리뷰를 찾을 수 없습니다."),

    //team chat 오류
    TEAM_CHAT_NOT_FOUND(HttpStatus.BAD_REQUEST, "TEAM_CHAT_ERROR_001", "팀 채팅을 찾을 수 없습니다."),

    // MongoDB 오류
    MONGO_ERROR(HttpStatus.BAD_REQUEST, "MONGO_ERROR_001", "오류가 발생하였습니다. 관리자에게 문의 바랍니다."),

    // WebSocket 오류
    WEB_SOCKET_ERROR(HttpStatus.BAD_REQUEST, "WEBSOCKET_ERROR_001", "오류가 발생하였습니다. 관리자에게 문의 바랍니다."),

    // 공통 오류
    COMMON_ERROR(HttpStatus.BAD_REQUEST, "COMMON_ERROR", "오류가 발생하였습니다. 관리자에게 문의 바랍니다.")

    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

}
