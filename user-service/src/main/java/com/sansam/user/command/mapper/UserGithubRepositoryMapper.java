package com.sansam.user.command.mapper;


import com.sansam.user.command.application.dto.UserGithubRepositoryDTO;
import com.sansam.user.command.domain.aggregate.entity.UserGithubRepository;

public class UserGithubRepositoryMapper {
    public static UserGithubRepository toEntity(UserGithubRepositoryDTO dto) {
        return UserGithubRepository.create(
                dto.getUserSeq(),
                dto.getUserRepositoryUrl(),
                dto.getUserRepositoryName(),
                dto.getDevelopType()
        );
    }
}
