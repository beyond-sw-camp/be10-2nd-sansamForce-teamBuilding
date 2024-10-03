package com.sansam.team.command.infrastructure.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamMemberSchedule;
import com.sansam.team.command.domain.repository.TeamMemberScheduleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeamMemberScheduleRepository extends TeamMemberScheduleRepository, JpaRepository<TeamMemberSchedule, Long> {
}
