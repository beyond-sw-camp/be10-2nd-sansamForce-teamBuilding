package sansam.team.buildingrule.command.domain.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.buildingrule.command.domain.domain.aggregate.BuildingRule;
import sansam.team.buildingrule.command.domain.domain.repositroy.BuildingRuleRepository;

public interface JpaBuildingRuleRepository extends BuildingRuleRepository, JpaRepository <BuildingRule, Long> {
}
