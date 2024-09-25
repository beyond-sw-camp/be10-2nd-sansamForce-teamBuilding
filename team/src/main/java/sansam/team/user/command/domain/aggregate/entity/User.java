package sansam.team.user.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import sansam.team.common.BaseTimeEntity;
import sansam.team.user.command.application.dto.mypagedto.MyPageDTO;
import sansam.team.user.command.domain.aggregate.RoleType;
import sansam.team.user.command.domain.aggregate.StatusType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Builder
@Entity
@Table(name = "tbl_user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;           // 회원 번호

    private Long majorSeq;          // 전공 번호

    private String userId;          // 회원 아이디

    private String userName;        // 회원 이름

    private String userNickname;    // 회원 닉네임

    private String userPassword;        // 회원 비밀번호

    @Enumerated(EnumType.STRING)
    private RoleType userAuth = RoleType.MEMBER;        // 회원 권한 (MANAGER, SUBMANAGER, MEMBER, MANTOR)

    private String userPhone;           // 회원 전화번호

    private String userEmail;           // 회원 이메일

    private String userBirthDate;       // 회원 생년월일

    private String userGender;          // 회원 성별

    private String userGithubId;        // 회원 깃허브 아이디

    private String userProfileImg;      // 회원 프로필 이미지

    @Enumerated(EnumType.STRING)
    private StatusType userStatus = StatusType.ACTIVE;      // 회원 상태 (ACTIVE, BAN, DELETE)

    private LocalDateTime userPwdModDate;   // 회원 비밀번호 수정 날짜

    private LocalDateTime userBanDate;      // 회원 정지 날짜

    private LocalDateTime delDate;      // 회원 탈퇴 날짜

    @Transient
    private String token;

    // JWT용 생성자
    public User(String name, String id, Collection<? extends GrantedAuthority> authorities) {
        this.userName = name;
        this.userId = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Spring Security 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /* 테스트용 userSeq 세터 메소드 */
    public void setUserSeq(Long userSeq) {
        this.userSeq = userSeq;
    }


    public void updateMyPageList(Long userSeq, MyPageDTO myPageDTO) {
        this.userSeq = userSeq;
        this.userNickname = myPageDTO.getUserNickname();
        this.userPhone = myPageDTO.getUserPhone();
        this.userEmail = myPageDTO.getUserEmail();
        this.userPassword = myPageDTO.getUserPassword();
        this.userGithubId = myPageDTO.getUserGithubId();
        this.userProfileImg = myPageDTO.getUserProfileImg();
    }
}

