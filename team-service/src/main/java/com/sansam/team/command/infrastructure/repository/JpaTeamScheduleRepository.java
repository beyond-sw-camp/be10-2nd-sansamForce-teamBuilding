package com.sansam.team.command.infrastructure.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamSchedule;
import com.sansam.team.command.domain.repository.TeamScheduleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeamScheduleRepository extends TeamScheduleRepository, JpaRepository<TeamSchedule, Long> {
}
