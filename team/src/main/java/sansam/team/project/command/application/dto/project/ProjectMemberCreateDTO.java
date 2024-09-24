package sansam.team.project.command.application.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sansam.team.common.YnType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberCreateDTO {

    private YnType projectMemberDelYn;
    private YnType projectMentorYn;
    private Long userSeq;
    private Long projectSeq;
}
