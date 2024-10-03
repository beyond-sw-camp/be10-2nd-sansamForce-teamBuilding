package com.sansam.user.query.service;


import com.sansam.user.command.application.dto.UserDTO;
import com.sansam.user.exception.CustomException;
import com.sansam.user.exception.ErrorCodeType;
import com.sansam.user.query.dto.UserQueryDTO;
import com.sansam.user.query.mapper.UserQueryMapper;
import com.sansam.user.security.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserQueryMapper userMapper;

    private final SecurityUtil securityUtil;

    public UserQueryDTO.LoginResponseDTO findByUserId(UserQueryDTO.LoginRequestDTO loginRequestDTO) throws CustomException {
        return userMapper.findByUserId(loginRequestDTO.getId())
                .filter(member -> securityUtil.bCryptPasswordEncoder().matches(loginRequestDTO.getPw(), member.getUserPassword()))
                .orElseThrow(() -> new CustomException(ErrorCodeType.USER_LOGIN_NOT_FOUND));
    }

    public UserDTO findById(Long userSeq) throws CustomException {
        return userMapper.findById(userSeq);
    }
}
