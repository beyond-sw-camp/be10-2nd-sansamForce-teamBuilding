package sansam.team.common.aggregate;

public enum RoleType {
    MANAGER("관리자", "MANAGER"),
    SUBMANAGER("중간관리자", "SUB_MANAGER"),
    MENTOR("강사", "MENTOR"),
    MEMBER("회원", "MEMBER");

    private final String role;
    private final String code;  // 영어 코드 추가

    RoleType(String role, String code) {
        this.role = role;
        this.code = code;
    }

    public String getRole() {
        return this.role;
    }

    public String getCode() {
        return this.code;  // 영어 코드 반환
    }
}
