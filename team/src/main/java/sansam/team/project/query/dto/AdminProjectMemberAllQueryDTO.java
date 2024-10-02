package sansam.team.project.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sansam.team.common.aggregate.YnType;
import sansam.team.common.aggregate.DevelopType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminProjectMemberAllQueryDTO {

    private Long userSeq;
    private String userName;
    private YnType projectMemberDelYn;
    private YnType projectMentorYn;
    private YnType projectMemberMajorYn;
    private DevelopType projectMemberDevelopType;
    private Long projectMemberCommitScore;
}
