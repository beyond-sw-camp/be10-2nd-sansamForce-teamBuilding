package sansam.team.user.command.domain.repository;

import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.command.domain.aggregate.entity.UserGithubRepository;

import java.util.Optional;

public interface UserGithubRepositoryRepository {
    
    UserGithubRepository save(UserGithubRepository userGithubRepository);

    Optional<UserGithubRepository> findById(Long userGithubRepositoryId);

    void deleteById(Long userGithubRepositorySeq);
}
