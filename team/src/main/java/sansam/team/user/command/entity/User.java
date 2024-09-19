package sansam.team.user.command.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import sansam.team.project.command.entity.ProjectApplyMember;
import sansam.team.project.command.entity.ProjectBoard;
import sansam.team.user.command.enums.RoleType;
import sansam.team.user.command.enums.StatusType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@Entity
@Table(name = "tbl_user")
@Getter
@Setter  // Setter를 추가하여 필요한 필드에 값을 설정할 수 있도록 함
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "user_id", nullable = false)
    private String id;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "user_nickname", nullable = false)
    private String nickname;

    @Column(name = "user_password", nullable = false)
    private String password;

    @Column(name = "user_auth", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType auth = RoleType.MEMBER;

    @Column(name = "user_phone")
    private String phone;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_birth_date")
    private String birthDate;

    @Column(name = "user_gender")
    private String gender;

    @Column(name = "user_github_id")
    private String githubId;

    @Column(name = "user_propile_img")
    private String profileImg;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private StatusType status = StatusType.ACTIVE;

    @Column(name = "user_pwd_mod_date", insertable = false)
    private LocalDateTime pwdModDate;

    @Column(name = "reg_date", updatable = false)
    private LocalDateTime regDate;

    @Column(name = "mod_date", insertable = false)
    private LocalDateTime modDate;

    @Column(name = "user_ban_date", insertable = false)
    private LocalDateTime banDate;

    @Column(name = "del_date", insertable = false)
    private LocalDateTime delDate;

    @Transient
    private String token;

    /* 프로젝트 모집글 */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectBoard> projectBoards = new ArrayList<>();

    /* 프로젝트 신청 회원 */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectApplyMember> projectApplyMembers = new ArrayList<>();

    // JWT용 생성자
    public User(String name, String id, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Spring Security 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return getAuth().getCode();  // 권한을 RoleType의 영어 코드로 반환
            }
        });

        return authorities;
    }
}
