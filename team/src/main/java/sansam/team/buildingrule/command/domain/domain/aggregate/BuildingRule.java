package sansam.team.buildingrule.command.domain.domain.aggregate;


import jakarta.persistence.*;
import lombok.*;
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

    public void updateFrom(BuildingRule updatedBuildingRule) {
        this.ruleTeamCount = updatedBuildingRule.getRuleTeamCount();
        this.ruleMajorWeight = updatedBuildingRule.getRuleMajorWeight();
        this.ruleCareerWeight = updatedBuildingRule.getRuleCareerWeight();
        this.ruleGithubWeight = updatedBuildingRule.getRuleGithubWeight();
        this.ruleTeamReviewWeight = updatedBuildingRule.getRuleTeamReviewWeight();
        this.ruleMentorReviewWeight = updatedBuildingRule.getRuleMentorReviewWeight();
        this.ruleTechStackYn = updatedBuildingRule.getRuleTechStackYn();
    }
}

