package sansam.team.buildingrule.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.buildingrule.command.application.dto.BuildingRuleDTO;
import sansam.team.buildingrule.command.domain.aggregate.BuildingRule;
import sansam.team.buildingrule.command.domain.repositroy.BuildingRuleRepository;


@Service
@RequiredArgsConstructor
public class BuildingRuleService {

    private final BuildingRuleRepository buildingRuleRepository;

    @Transactional
    public BuildingRule createBuildingRule(BuildingRuleDTO buildingRuleDTO) {
        BuildingRule buildingRule = new BuildingRule();
        buildingRule.updateFrom(buildingRuleDTO);
        return buildingRuleRepository.save(buildingRule);
    }

    @Transactional
    public BuildingRule updateBuildingRule(long ruleSeq, BuildingRuleDTO buildingRuleDTO) {
        BuildingRule existingBuildingRule = buildingRuleRepository.findById(ruleSeq)
                .orElseThrow(() -> new IllegalArgumentException("Rule not found"));

        existingBuildingRule.updateFrom(buildingRuleDTO);

        return buildingRuleRepository.save(existingBuildingRule);
    }

    @Transactional
    public void deleteBuildingRule(long ruleSeq) {
        buildingRuleRepository.deleteById(ruleSeq);
    }
}

