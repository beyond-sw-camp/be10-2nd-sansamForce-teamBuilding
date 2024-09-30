package sansam.team.buildingrule.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.buildingrule.command.domain.aggregate.BuildingRule;
import sansam.team.buildingrule.command.domain.repositroy.BuildingRuleRepository;

public interface JpaBuildingRuleRepository extends BuildingRuleRepository, JpaRepository<BuildingRule, Long> {
}
