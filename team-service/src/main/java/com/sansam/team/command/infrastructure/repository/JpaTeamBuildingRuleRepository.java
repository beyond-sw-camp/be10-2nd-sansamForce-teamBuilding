package com.sansam.team.command.infrastructure.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamBuildingRule;
import com.sansam.team.command.domain.repository.TeamBuildingRuleRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeamBuildingRuleRepository extends TeamBuildingRuleRepository, JpaRepository<TeamBuildingRule, Long> {
}
