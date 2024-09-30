package sansam.team.project.query.dto.project;

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
public class ProjectMemberAdminAllQueryDTO {

    private Long userSeq;
    private String userName;
    private YnType projectMemberDelYn;
    private YnType projectMentorYn;
    private YnType projectMemberMajorYn;
    private InterestType projectMemberInterestType;
    private Long projectMemberCommitScore;
}
