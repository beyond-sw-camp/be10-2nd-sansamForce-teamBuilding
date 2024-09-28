package sansam.team.buildingrule.command.domain.application.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.buildingrule.command.domain.domain.aggregate.BuildingRule;
import sansam.team.buildingrule.command.domain.domain.repositroy.BuildingRuleRepository;

@Service
@RequiredArgsConstructor
public class BuildingRuleService {

        private final BuildingRuleRepository buildingRuleRepository;

        @Transactional
        public BuildingRule createBuildingRule(BuildingRule buildingRule) {
            return buildingRuleRepository.save(buildingRule);
        }

        @Transactional
        public BuildingRule updateBuildingRule(int ruleSeq, BuildingRule updatedBuildingRule) {
            BuildingRule existingBuildingRule = buildingRuleRepository.findById(ruleSeq)
                    .orElseThrow(() -> new IllegalArgumentException("Rule not found"));

            existingBuildingRule.updateFrom(updatedBuildingRule);

            return buildingRuleRepository.save(existingBuildingRule);
        }

        @Transactional
        public void deleteBuildingRule(int ruleSeq) {
            buildingRuleRepository.deleteById(ruleSeq);
        }

}


