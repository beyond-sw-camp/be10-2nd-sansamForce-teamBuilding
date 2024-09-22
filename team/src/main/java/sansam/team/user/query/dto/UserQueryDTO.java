package sansam.team.user.query.dto;

import lombok.*;
import sansam.team.common.BaseTimeEntity;
import sansam.team.common.jwt.JwtToken;
import sansam.team.user.command.domain.aggregate.RoleType;
import sansam.team.user.command.domain.aggregate.StatusType;

import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class UserQueryDTO extends BaseTimeEntity {

    private Long userSeq;

    private String id;

    private String name;

    private String nickname;

    private String password;

    private RoleType auth = RoleType.MEMBER;

    private String phone;

    private String email;

    private String birthDate;

    private String gender;

    private String githubId;

    private String profileImg;

    private StatusType status = StatusType.ACTIVE;

    private LocalDateTime pwdModDate;

    private LocalDateTime banDate;

    private LocalDateTime delDate;

    @Getter
    public static class LoginRequestDTO {
        private String id;
        private String pw;
    }

    @Getter
    @Setter
    public static class LoginResponseDTO {
        private Long userSeq;
        private String userId;
        private String userPassword;
        private String userName;
        private RoleType userAuth;
        private JwtToken jwtToken;
    }

}
