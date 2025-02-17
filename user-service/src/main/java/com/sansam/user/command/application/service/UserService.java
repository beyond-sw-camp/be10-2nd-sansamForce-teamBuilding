package com.sansam.user.command.application.service;


import com.sansam.user.command.application.dto.UserDTO;
import com.sansam.user.command.application.dto.UserUpdateRequestDTO;
import com.sansam.user.command.domain.aggregate.entity.User;
import com.sansam.user.command.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public boolean joinProcess(UserDTO.UserJoinDTO userJoinDTO) {
        userJoinDTO.changePasswordEncoder(userJoinDTO.getPassword());
        User user = modelMapper.map(userJoinDTO, User.class);

        boolean isOk = true;
        try {
            userRepository.save(user);
        } catch (Exception e) {
            isOk = false;
            log.error(e.getMessage());
        }

        return isOk;
    }

    @Transactional
    public User updateUser(Long userSeq, UserUpdateRequestDTO request) {
        User user = userRepository.findById(userSeq).orElseThrow(() -> new EntityNotFoundException("can't find user"));

        // User 엔티티 업데이트
        user.modifyUser(request);

        return user;
    }

}
