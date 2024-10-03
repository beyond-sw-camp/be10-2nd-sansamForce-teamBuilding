package com.sansam.team.command.domain.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamBuildingRule;

import java.util.Optional;

public interface TeamBuildingRuleRepository {
    TeamBuildingRule save(TeamBuildingRule buildingRule);
    Optional<TeamBuildingRule> findById(long ruleSeq);
    void deleteById(long ruleSeq);
}