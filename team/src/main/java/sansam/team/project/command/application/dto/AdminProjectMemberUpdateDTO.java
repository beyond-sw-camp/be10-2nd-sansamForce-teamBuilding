package sansam.team.project.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sansam.team.common.aggregate.YnType;
import sansam.team.project.command.domain.aggregate.InterestType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminProjectMemberUpdateDTO {
    private YnType projectMemberDelYn;
    private YnType projectMentorYn;
    private InterestType projectInterest;
    private YnType majorYn;
    private Long projectMemberCommitScore;
}