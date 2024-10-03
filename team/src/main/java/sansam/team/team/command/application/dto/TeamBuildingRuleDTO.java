package sansam.team.team.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sansam.team.common.aggregate.YnType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamBuildingRuleDTO {
    private int ruleTeamCount;
    private int ruleMajorWeight;
    private int ruleCareerWeight;
    private int ruleGithubWeight;
    private int ruleTeamReviewWeight;
    private int ruleMentorReviewWeight;
    private YnType ruleTechStackYn;
}
