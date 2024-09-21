package sansam.team.team.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.repository.TeamRepository;

public interface JpaTeamRepository extends TeamRepository, JpaRepository<Team, Long> {
}
