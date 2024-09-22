package sansam.team.user.command.domain.aggregate;

public enum StatusType {
    ACTIVE("활동중"),
    BAN("정지"),
    DELETE("탈퇴");

    private final String status;
    StatusType(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }

}
