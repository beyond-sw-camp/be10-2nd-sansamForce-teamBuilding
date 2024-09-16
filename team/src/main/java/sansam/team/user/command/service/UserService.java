package sansam.team.user.command.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.common.JWTUtil;
import sansam.team.user.command.dto.JwtToken;
import sansam.team.user.command.dto.UserDTO;
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

    public JwtToken loginProcess(String id, String pw) throws UsernameNotFoundException, JsonProcessingException {
        User user = userRepository.findById(id)
                .filter(member -> passwordEncoder.matches(pw, member.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getId(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        JwtToken token = jwtUtil.createToken(authentication);

        return token;
    }

    @Transactional
    public boolean joinProcess(UserDTO userDTO) {
        userDTO.changePasswordEncoder(userDTO.getPassword());
        userDTO.changeAuthMember();
        User user = modelMapper.map(userDTO, User.class);

        boolean isOk = true;
        try {
            userRepository.save(user);
        } catch (Exception e) {
            isOk = false;
        }

        return isOk;
    }

}
