package sansam.team.user.command.application.dto;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserJoinDTO {

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
