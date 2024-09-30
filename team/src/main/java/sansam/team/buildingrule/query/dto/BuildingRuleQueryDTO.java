package sansam.team.buildingrule.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BuildingRuleQueryDTO {
    private int ruleSeq;
    private int ruleTeamCount;
    private int ruleMajorWeight;
    private int ruleCareerWeight;
    private int ruleGithubWeight;
    private int ruleTeamReviewWeight;
    private int ruleMentorReviewWeight;
    private String ruleTechStackYn;
}
