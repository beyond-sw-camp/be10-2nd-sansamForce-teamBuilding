package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.team.command.application.dto.TeamBuildingRuleDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamBuildingRule;
import sansam.team.team.command.domain.repository.TeamBuildingRuleRepository;


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

