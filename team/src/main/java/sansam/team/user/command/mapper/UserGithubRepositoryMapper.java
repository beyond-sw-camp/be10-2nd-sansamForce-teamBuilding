package sansam.team.user.command.mapper;

import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.user.command.application.dto.UserGithubRepositoryDTO;
import sansam.team.user.command.domain.aggregate.entity.UserGithubRepository;

public class UserGithubRepositoryMapper {
    public static UserGithubRepository toEntity(UserGithubRepositoryDTO dto) {
        return UserGithubRepository.create(
                dto.getUserRepositoryUrl(),
                dto.getUserRepositoryName(),
                dto.getDevelopType(),
                dto.getUserSeq()
        );
    }
}
