package sansam.team.buildingrule.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuildingRuleDTO {
    private int ruleTeamCount;
    private int ruleMajorWeight;
    private int ruleCareerWeight;
    private int ruleGithubWeight;
    private int ruleTeamReviewWeight;
    private int ruleMentorReviewWeight;
    private String ruleTechStackYn;
}
