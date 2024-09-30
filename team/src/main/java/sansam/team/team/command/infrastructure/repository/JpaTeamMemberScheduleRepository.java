package sansam.team.team.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.domain.aggregate.entity.TeamMemberSchedule;
import sansam.team.team.command.domain.repository.TeamMemberScheduleRepository;

public interface JpaTeamMemberScheduleRepository extends TeamMemberScheduleRepository, JpaRepository<TeamMemberSchedule, Long> {
}
