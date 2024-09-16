package sansam.team.user.command.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.common.jwt.JWTUtil;
import sansam.team.user.command.dto.JwtToken;
import sansam.team.user.command.dto.LoginRequestDTO;
import sansam.team.user.command.dto.UserDTO;
import sansam.team.user.command.dto.UserJoinDTO;
import sansam.team.user.command.entity.User;
import sansam.team.user.command.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    // 로그인 처리 메서드 (LoginRequestDTO 사용)
    // 로그인 처리 메서드 (LoginRequestDTO 사용)
    public JwtToken loginProcess(LoginRequestDTO loginRequestDTO) throws UsernameNotFoundException, JsonProcessingException {
        // LoginRequestDTO에서 ID와 PW 추출
        String id = loginRequestDTO.getId();
        String pw = loginRequestDTO.getPw();

        // 사용자를 DB에서 찾고 비밀번호를 비교
        User user = userRepository.findById(id)
                .filter(member -> passwordEncoder.matches(pw, member.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));

        // JWT 토큰 생성 및 반환
        return jwtUtil.createToken(user);
    }

    // 사용자를 조회하는 메서드
    public UserDTO findById(LoginRequestDTO loginRequestDTO) {
        // LoginRequestDTO에서 ID 추출
        String id = loginRequestDTO.getId();

        // 사용자를 조회
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // User 엔티티를 UserDTO로 변환하여 반환
        return new UserDTO(user.getId(), user.getAuth(), user.getName());
    }

    @Transactional
    public boolean joinProcess(UserJoinDTO userJoinDTO) {
        // 비밀번호 인코딩
        userJoinDTO.changePasswordEncoder(userJoinDTO.getPassword());
        userJoinDTO.changeAuthMember();

        // DTO를 엔티티로 변환
        User user = modelMapper.map(userJoinDTO, User.class);

        boolean isOk = true;
        try {
            userRepository.save(user); // DB에 사용자 저장
        } catch (Exception e) {
            isOk = false;
            e.printStackTrace();
        }

        return isOk;
    }
}
