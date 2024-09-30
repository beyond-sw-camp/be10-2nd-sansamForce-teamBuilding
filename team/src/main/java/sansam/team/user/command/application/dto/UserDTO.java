package sansam.team.user.command.application.dto;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sansam.team.common.aggregate.entity.BaseTimeEntity;
import sansam.team.common.aggregate.RoleType;
import sansam.team.user.command.domain.aggregate.StatusType;
import sansam.team.common.jwt.JwtToken;

import java.time.LocalDateTime;

@Getter
@ToString(exclude = "jwtToken")
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends BaseTimeEntity {

    private Long userSeq;

    private String id;

    private String name;

    private String nickname;

    private String password;

    private RoleType auth;

    private String phone;

    private String email;

    private String birthDate;

    private String gender;

    private String githubId;

    private String profileImg;

    private StatusType status;

    private LocalDateTime pwdModDate;

    private LocalDateTime banDate;

    private LocalDateTime delDate;

    private JwtToken jwtToken;

    public void setJwtToken(JwtToken token) {
        this.jwtToken = token;
    }

    public UserDTO(String id, RoleType auth, String name) {
        this.id = id;
        this.auth = auth;
        this.name = name;
    }

    @Getter
    public static class UserJoinDTO {

        private String id;
        private String name;
        private String nickname;
        private String password;
        private String phone;
        private String email;
        private String birthDate;
        private String gender;

        public void changePasswordEncoder(String password) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            this.password = bCryptPasswordEncoder.encode(password);
        }
    }

}
