package sansam.team.user.command.domain.aggregate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sansam.team.user.command.domain.aggregate.entity.User;

import java.util.ArrayList;
import java.util.Collection;

public class UserPrincipal implements UserDetails {
    private final User user; // User 엔티티를 포함

    // 생성자
    public UserPrincipal(User user) {
        this.user = user;
    }

    // User 엔티티의 정보를 가져올 수 있는 메서드들
    public Long getUserSeq() {
        return user.getUserSeq();
    }

    public String getUserId() {
        return user.getUserId();
    }

    public String getUserName() {
        return user.getUserName();
    }

    public RoleType getUserAuth() {
        return user.getUserAuth();
    }

    // UserDetails 인터페이스 메서드 구현
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(() -> user.getUserAuth().getCode()); // 권한을 RoleType의 코드로 반환
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword(); // 비밀번호 반환
    }

    @Override
    public String getUsername() {
        return user.getUserId(); // 사용자 아이디 반환
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정이 만료되지 않음을 반환
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정이 잠기지 않음을 반환
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 자격 증명이 만료되지 않음을 반환
    }

    @Override
    public boolean isEnabled() {
        return user.getUserStatus() == StatusType.ACTIVE; // 계정 활성 상태 확인
    }
}
