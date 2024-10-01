package sansam.team.user.query.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sansam.team.security.util.JWTUtil;
import sansam.team.security.jwt.JwtToken;
import sansam.team.security.config.SecurityConfig;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.query.dto.UserQueryDTO;
import sansam.team.user.query.mapper.UserQueryMapper;


@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserQueryMapper userMapper;

    private final SecurityConfig securityConfig;

    public UserQueryDTO.LoginResponseDTO findById(UserQueryDTO.LoginRequestDTO loginRequestDTO) throws CustomException {
        return userMapper.findByUserId(loginRequestDTO.getId())
                .filter(member -> securityConfig.bCryptPasswordEncoder().matches(loginRequestDTO.getPw(), member.getUserPassword()))
                .orElseThrow(() -> new CustomException(ErrorCodeType.USER_LOGIN_NOT_FOUND));
    }

}
