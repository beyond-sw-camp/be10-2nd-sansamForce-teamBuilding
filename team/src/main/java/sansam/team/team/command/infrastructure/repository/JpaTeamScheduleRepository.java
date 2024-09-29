package sansam.team.team.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.domain.aggregate.entity.TeamSchedule;
import sansam.team.team.command.domain.repository.TeamScheduleRepository;

public interface JpaTeamScheduleRepository extends TeamScheduleRepository, JpaRepository<TeamSchedule, Long> {
}
