package sansam.team.user.command.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sansam.team.user.command.enums.RoleType;
import sansam.team.user.command.enums.StatusType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@ToString(exclude = "jwtToken")
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

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

    private JwtToken jwtToken;

    public UserDTO(String id, RoleType auth, String name) {
        this.id = id;
        this.auth = auth;
        this.name = name;
    }

}
