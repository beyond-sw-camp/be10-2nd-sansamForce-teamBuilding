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
public class ProjectMemberUpdateDTO {
    private YnType projectMemberDelYn;
    private YnType projectMentorYn;
}