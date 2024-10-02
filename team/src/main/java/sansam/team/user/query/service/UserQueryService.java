package sansam.team.user.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.security.util.SecurityUtil;
import sansam.team.user.query.dto.UserQueryDTO;
import sansam.team.user.query.mapper.UserQueryMapper;


@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserQueryMapper userMapper;

    private final SecurityUtil securityUtil;

    public UserQueryDTO.LoginResponseDTO findById(UserQueryDTO.LoginRequestDTO loginRequestDTO) throws CustomException {
        return userMapper.findByUserId(loginRequestDTO.getId())
                .filter(member -> securityUtil.bCryptPasswordEncoder().matches(loginRequestDTO.getPw(), member.getUserPassword()))
                .orElseThrow(() -> new CustomException(ErrorCodeType.USER_LOGIN_NOT_FOUND));
    }

}
