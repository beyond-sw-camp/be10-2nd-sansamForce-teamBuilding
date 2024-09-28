package sansam.team.buildingrule.command.domain.domain.repositroy;

import sansam.team.buildingrule.command.domain.domain.aggregate.BuildingRule;

import java.util.Optional;

public interface BuildingRuleRepository {

    BuildingRule save(BuildingRule buildingRule);

    Optional<BuildingRule> findById(int ruleSeq);

    void deleteById(int ruleSeq);
}
