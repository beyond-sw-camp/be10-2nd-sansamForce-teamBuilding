package com.sansam.team.command.infrastructure.repository;


import com.sansam.team.command.domain.aggregate.entity.Team;
import com.sansam.team.command.domain.repository.TeamRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeamRepository extends TeamRepository, JpaRepository<Team, Long> {
}
