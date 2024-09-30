package sansam.team.team.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.domain.aggregate.entity.TeamBuildingRule;
import sansam.team.team.command.domain.repository.TeamBuildingRuleRepository;

public interface JpaTeamBuildingRuleRepository extends TeamBuildingRuleRepository, JpaRepository<TeamBuildingRule, Long> {
}
