package sansam.team.user.command.dto;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sansam.team.user.command.enums.RoleType;
import sansam.team.user.command.enums.StatusType;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinDTO {
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
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private LocalDateTime banDate;
    private LocalDateTime delDate;

    public void changePasswordEncoder(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.password = bCryptPasswordEncoder.encode(password);
    }

    public void changeAuthMember() {
        this.auth = RoleType.MEMBER;
    }
}
