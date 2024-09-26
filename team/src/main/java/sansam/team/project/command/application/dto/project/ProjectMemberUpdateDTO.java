package sansam.team.project.command.application.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sansam.team.common.YnType;
import sansam.team.project.command.domain.aggregate.InterestType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberUpdateDTO {
    private YnType projectMemberDelYn;
    private YnType projectMentorYn;
    private InterestType projectInterest;
    private YnType majorYn;
    private Long projectMemberCommitScore;
}