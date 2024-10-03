package com.sansam.user.command.application.service;


import com.sansam.user.command.application.dto.UserGithubRepositoryDTO;
import com.sansam.user.command.domain.aggregate.entity.UserGithubRepository;
import com.sansam.user.command.domain.repository.UserGithubRepositoryRepository;
import com.sansam.user.command.domain.repository.UserRepository;
import com.sansam.user.command.mapper.UserGithubRepositoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserGithubRepositoryService {
    private final UserGithubRepositoryRepository userGithubRepositoryRepository;
    private final UserRepository userRepository;

    @Transactional
    public UserGithubRepository createRepository(UserGithubRepositoryDTO dto) {
        UserGithubRepository userGithubRepository = UserGithubRepositoryMapper.toEntity(dto);
        userGithubRepositoryRepository.save(userGithubRepository);
        return userGithubRepository;
    }
    @Transactional
    public UserGithubRepository updateRepository(Long userGithubRepositorySeq, UserGithubRepositoryDTO dto) {
        UserGithubRepository userGithubRepository = userGithubRepositoryRepository.findById(userGithubRepositorySeq).orElseThrow();
        userGithubRepository.modifyUserGithubRepository(dto.getUserRepositoryUrl(),dto.getUserRepositoryUrl(),dto.getDevelopType());
        return userGithubRepository;
    }

    @Transactional
    public void deleteRepository(Long userGithubRepositorySeq) {
        userGithubRepositoryRepository.deleteById(userGithubRepositorySeq);
    }


}


