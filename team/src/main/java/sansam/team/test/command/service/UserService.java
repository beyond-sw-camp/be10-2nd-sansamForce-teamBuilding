package sansam.team.test.command.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sansam.team.common.JWTUtil;
import sansam.team.test.command.dto.UserDTO;
import sansam.team.test.command.entity.User;
import sansam.team.test.command.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final JWTUtil jwtUtil;

    public User loginProcess(String id, String pw) throws UsernameNotFoundException {
        return userRepository.findByIdAndPassword(id, pw)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 회원을 찾을 수 없습니다."));
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
