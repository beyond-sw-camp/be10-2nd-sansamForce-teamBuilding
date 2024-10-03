package com.sansam.user.query.service;


import com.sansam.user.query.dto.UserGithubRepositoryQueryDTO;
import com.sansam.user.query.mapper.UserGithubRepositoryQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGithubRepositoryQueryService {

    private final UserGithubRepositoryQueryMapper userGithubRepositoryQueryMapper;

    public List<UserGithubRepositoryQueryDTO> getAllGithubRepo(Long userSeq) {
        return userGithubRepositoryQueryMapper.findAllGithubRepoByUserSeq(userSeq);
    }
}
