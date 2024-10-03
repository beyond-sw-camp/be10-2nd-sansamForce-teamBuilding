package com.sansam.user.command.application.dto;


import com.sansam.user.command.domain.aggregate.StatusType;
import com.sansam.user.common.aggregate.RoleType;
import com.sansam.user.common.aggregate.entity.BaseTimeEntity;
import com.sansam.user.security.jwt.JwtToken;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    private Long careerYears;

    private Long careerMonths;


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
