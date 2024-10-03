package com.sansam.user.command.infrastructure.repository;


import com.sansam.user.command.domain.aggregate.entity.UserGithubRepository;
import com.sansam.user.command.domain.repository.UserGithubRepositoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserGithubRepositoryRepository extends UserGithubRepositoryRepository, JpaRepository<UserGithubRepository, Long> {
}
