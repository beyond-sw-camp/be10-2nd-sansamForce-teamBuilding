package sansam.team.user.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.user.command.domain.aggregate.entity.UserGithubRepository;
import sansam.team.user.command.domain.repository.UserGithubRepositoryRepository;

public interface JpaUserGithubRepositoryRepository extends UserGithubRepositoryRepository, JpaRepository<UserGithubRepository, Long> {
}
