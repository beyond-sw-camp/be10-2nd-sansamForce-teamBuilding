package sansam.team.test.command.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sansam.team.test.command.enums.RoleType;
import sansam.team.test.command.enums.StatusType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Setter
@Getter
@ToString
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

    private String propileImg;

    private StatusType status;

    private LocalDateTime pwdModDate;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private LocalDateTime banDate;

    private LocalDateTime delDate;

    private JwtToken jwtToken;

    public void changePasswordEncoder(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.password = bCryptPasswordEncoder.encode(password);
    }

    public void changeAuthMember() {
        this.auth = RoleType.MEMBER;
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Collection<? extends GrantedAuthority> authorities) {

        Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {
            public String getAuthority() {
                return getAuth().getRole();
            }
        });

        return collection;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}
