package com.sansam.user.query.service;


import com.sansam.user.exception.CustomException;
import com.sansam.user.exception.ErrorCodeType;
import com.sansam.user.query.dto.CustomUserDTO;
import com.sansam.user.query.dto.UserQueryDTO;
import com.sansam.user.query.mapper.UserQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserQueryMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserQueryDTO.LoginResponseDTO user = userMapper.findByUserId(userId)
                .filter(pw -> pw.getUserPassword()!=null)
                .orElseThrow(() -> new CustomException(ErrorCodeType.USER_LOGIN_NOT_FOUND));

        return new CustomUserDTO(
                String.valueOf(user.getUserSeq()),
                user.getUserPassword(),
                user.getAuthorities(),
                user.getUserSeq(),
                user.getUserId(),
                user.getUserAuth()
        );
    }

}
