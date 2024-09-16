package sansam.team.user.command.enums;

public enum RoleType {
    MANAGER("관리자"),
    SUBMANAGER("중간관리자"),
    MENTOR("강사"),
    MEMBER("회원");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }
    public String getRole() {
        return this.role;
    }

}
