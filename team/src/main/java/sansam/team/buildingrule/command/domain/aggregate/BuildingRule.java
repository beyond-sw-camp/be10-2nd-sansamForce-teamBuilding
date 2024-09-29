package sansam.team.buildingrule.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.buildingrule.command.application.dto.BuildingRuleDTO;
import sansam.team.common.BaseTimeEntity;
import sansam.team.common.YnType;

@Entity
@Table(name = "tbl_building_rule")
@Getter
@NoArgsConstructor
public class BuildingRule extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ruleSeq;
    private int ruleTeamCount;
    private int ruleMajorWeight;
    private int ruleCareerWeight;
    private int ruleGithubWeight;
    private int ruleTeamReviewWeight;
    private int ruleMentorReviewWeight;

    @Enumerated(EnumType.STRING)
    private YnType ruleTechStackYn;

    public void updateFrom(BuildingRuleDTO buildingRuleDTO) {
        this.ruleTeamCount = buildingRuleDTO.getRuleTeamCount();
        this.ruleMajorWeight = buildingRuleDTO.getRuleMajorWeight();
        this.ruleCareerWeight = buildingRuleDTO.getRuleCareerWeight();
        this.ruleGithubWeight = buildingRuleDTO.getRuleGithubWeight();
        this.ruleTeamReviewWeight = buildingRuleDTO.getRuleTeamReviewWeight();
        this.ruleMentorReviewWeight = buildingRuleDTO.getRuleMentorReviewWeight();
        this.ruleTechStackYn = YnType.valueOf(buildingRuleDTO.getRuleTechStackYn()); // Enum 변환
    }
}
