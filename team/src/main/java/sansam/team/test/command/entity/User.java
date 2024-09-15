package sansam.team.test.command.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import sansam.team.test.command.enums.RoleType;
import sansam.team.test.command.enums.StatusType;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "tbl_user")
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name="user_id", nullable = false)
    private String id;

    @Column(name="user_name", nullable = false)
    private String name;

    @Column(name="user_nickname", nullable = false)
    private String nickname;

    @Column(name="user_password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="user_auth") @ColumnDefault("MEMBER")
    private RoleType auth;

    @Column(name="user_phone")
    private String phone;

    @Column(name="user_email")
    private String email;

    @Column(name="user_birth_date")
    private String birthDate;

    @Column(name="user_gender")
    private String gender;

    @Column(name="user_github_id")
    private String githubId;

    @Column(name="user_propile_img")
    private String propileImg;

    @Column(name="user_status")
    private StatusType status;

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

}
