package com.sansam.team.command.application.service;


import com.sansam.team.command.application.dto.TeamBuildingRuleDTO;
import com.sansam.team.command.domain.aggregate.entity.TeamBuildingRule;
import com.sansam.team.command.domain.repository.TeamBuildingRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamBuildingRuleService {

    private final TeamBuildingRuleRepository buildingRuleRepository;

    @Transactional
    public TeamBuildingRule createBuildingRule(TeamBuildingRuleDTO buildingRuleDTO) {
        TeamBuildingRule buildingRule = new TeamBuildingRule();
        buildingRule.updateFrom(buildingRuleDTO);
        return buildingRuleRepository.save(buildingRule);
    }

    @Transactional
    public TeamBuildingRule updateBuildingRule(long ruleSeq, TeamBuildingRuleDTO buildingRuleDTO) {
        TeamBuildingRule existingBuildingRule = buildingRuleRepository.findById(ruleSeq)
                .orElseThrow(() -> new IllegalArgumentException("Rule not found"));

        existingBuildingRule.updateFrom(buildingRuleDTO);

        return buildingRuleRepository.save(existingBuildingRule);
    }

    @Transactional
    public void deleteBuildingRule(long ruleSeq) {
        buildingRuleRepository.deleteById(ruleSeq);
    }
}

