package sansam.team.user.command.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.common.JWTUtil;
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

    public User loginProcess(String id, String pw) throws UsernameNotFoundException {
        User user = userRepository.findById(id)
                .filter(member -> passwordEncoder.matches(pw, member.getPassword()))
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));

        String token = jwtUtil.createToken(String.format("%s:%s", user.getId(), user.getAuth()));
        user.setToken(token);

        return user;
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
