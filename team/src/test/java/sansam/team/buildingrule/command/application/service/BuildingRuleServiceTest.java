package sansam.team.buildingrule.command.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.common.aggregate.YnType;
import sansam.team.team.command.application.dto.TeamBuildingRuleDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamBuildingRule;
import sansam.team.team.command.domain.repository.TeamBuildingRuleRepository;
import sansam.team.team.command.application.service.TeamBuildingRuleService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
@Transactional
public class BuildingRuleServiceTest {

    @Autowired
    private TeamBuildingRuleRepository buildingRuleRepository;

    private TeamBuildingRuleService buildingRuleService;

    @BeforeEach
    public void setUp() {
        this.buildingRuleService = new TeamBuildingRuleService(buildingRuleRepository);
    }

    @Test
    public void testCreateBuildingRule() {
        TeamBuildingRuleDTO buildingRuleDTO = new TeamBuildingRuleDTO();
        buildingRuleDTO.setRuleTeamCount(5);
        buildingRuleDTO.setRuleMajorWeight(4);
        buildingRuleDTO.setRuleCareerWeight(3);
        buildingRuleDTO.setRuleGithubWeight(2);
        buildingRuleDTO.setRuleTeamReviewWeight(1);
        buildingRuleDTO.setRuleMentorReviewWeight(5);
        buildingRuleDTO.setRuleTechStackYn("Y");

        TeamBuildingRule createdBuildingRule = buildingRuleService.createBuildingRule(buildingRuleDTO);

        assertThat(createdBuildingRule).isNotNull();
        assertThat(createdBuildingRule.getRuleTeamCount()).isEqualTo(5);
        assertThat(createdBuildingRule.getRuleMajorWeight()).isEqualTo(4);
    }

    @Test
    public void testUpdateBuildingRule() {
        TeamBuildingRule buildingRule = new TeamBuildingRule();
        buildingRule.updateFrom(new TeamBuildingRuleDTO(4, 3, 2, 1, 5, 5, "Y"));
        buildingRuleRepository.save(buildingRule);

        TeamBuildingRuleDTO updateDTO = new TeamBuildingRuleDTO();
        updateDTO.setRuleTeamCount(3);
        updateDTO.setRuleMajorWeight(2);
        updateDTO.setRuleCareerWeight(1);
        updateDTO.setRuleGithubWeight(4);
        updateDTO.setRuleTeamReviewWeight(5);
        updateDTO.setRuleMentorReviewWeight(5);
        updateDTO.setRuleTechStackYn("N");

        TeamBuildingRule updatedBuildingRule = buildingRuleService.updateBuildingRule(buildingRule.getRuleSeq(), updateDTO);

        assertThat(updatedBuildingRule).isNotNull();
        assertThat(updatedBuildingRule.getRuleTeamCount()).isEqualTo(3);
        assertThat(updatedBuildingRule.getRuleTechStackYn()).isEqualTo(YnType.N);
    }

    @Test
    public void testDeleteBuildingRule() {
        TeamBuildingRule buildingRule = new TeamBuildingRule();
        buildingRule.updateFrom(new TeamBuildingRuleDTO(5, 5, 5, 5, 5, 5, "Y"));
        TeamBuildingRule savedRule = buildingRuleRepository.save(buildingRule);

        buildingRuleService.deleteBuildingRule(savedRule.getRuleSeq());

        assertThrows(IllegalArgumentException.class, () -> {
            buildingRuleService.updateBuildingRule(savedRule.getRuleSeq(), new TeamBuildingRuleDTO());
        });
    }
}
