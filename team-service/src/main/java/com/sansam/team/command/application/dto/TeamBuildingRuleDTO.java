package com.sansam.team.command.application.dto;


import com.sansam.team.common.aggregate.YnType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
