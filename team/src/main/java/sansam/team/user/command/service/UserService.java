package sansam.team.user.command.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
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
        // 사용자를 ID로 조회
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 회원을 찾을 수 없습니다."));

        // 비밀번호 비교
        if (!passwordEncoder.matches(pw, user.getPassword())) {
            throw new UsernameNotFoundException("비밀번호가 일치하지 않습니다.");
        }

        return user;  // 비밀번호가 일치하면 사용자 정보를 반환
    }

    private User createUserDetails(User member) {
        return User.builder()
                .id(member.getId())
                .password(member.getPassword())
                .auth(member.getAuth())
                .build();
    }

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
