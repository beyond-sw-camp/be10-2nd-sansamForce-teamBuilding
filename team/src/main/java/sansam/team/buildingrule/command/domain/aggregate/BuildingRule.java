package sansam.team.buildingrule.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.buildingrule.command.application.dto.BuildingRuleDTO;
import sansam.team.common.aggregate.YnType;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

@Entity
@Table(name = "tbl_building_rule")
@Getter
@NoArgsConstructor
public class BuildingRule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ruleSeq;
    private int ruleTeamCount;
    private int ruleMajorWeight;
    private int ruleCareerWeight;
    private int ruleGithubWeight;
    private int ruleTeamReviewWeight;
    private int ruleMentorReviewWeight;

    @Enumerated(EnumType.STRING)
    private YnType ruleTechStackYn;

    public BuildingRuleDTO toDTO() {
        BuildingRuleDTO buildingRuleDTO = new BuildingRuleDTO();
        buildingRuleDTO.setRuleTeamCount(this.ruleTeamCount);
        buildingRuleDTO.setRuleMajorWeight(this.ruleMajorWeight);
        buildingRuleDTO.setRuleCareerWeight(this.ruleCareerWeight);
        buildingRuleDTO.setRuleGithubWeight(this.ruleGithubWeight);
        buildingRuleDTO.setRuleTeamReviewWeight(this.ruleTeamReviewWeight);
        buildingRuleDTO.setRuleMentorReviewWeight(this.ruleMentorReviewWeight);
        buildingRuleDTO.setRuleTechStackYn(this.ruleTechStackYn.name()); // Enum을 String으로 변환
        return buildingRuleDTO;
    }

    public void updateFrom(BuildingRuleDTO buildingRuleDTO) {
        this.ruleTeamCount = buildingRuleDTO.getRuleTeamCount();
        this.ruleMajorWeight = buildingRuleDTO.getRuleMajorWeight();
        this.ruleCareerWeight = buildingRuleDTO.getRuleCareerWeight();
        this.ruleGithubWeight = buildingRuleDTO.getRuleGithubWeight();
        this.ruleTeamReviewWeight = buildingRuleDTO.getRuleTeamReviewWeight();
        this.ruleMentorReviewWeight = buildingRuleDTO.getRuleMentorReviewWeight();
        this.ruleTechStackYn = YnType.valueOf(buildingRuleDTO.getRuleTechStackYn());
    }
}
