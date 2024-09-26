package sansam.team.user.command.domain.aggregate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusType {
    ACTIVE("활동중"),
    BAN("정지"),
    DELETE("탈퇴");

    private final String status;

}
