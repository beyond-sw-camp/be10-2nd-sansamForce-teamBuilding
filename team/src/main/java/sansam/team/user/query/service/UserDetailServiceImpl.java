package sansam.team.user.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.user.query.mapper.UserQueryMapper;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserQueryMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userMapper.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCodeType.USER_LOGIN_NOT_FOUND));
    }

}
