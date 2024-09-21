package sansam.team.project.command.application.dto.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sansam.team.project.command.domain.aggregate.ApplyStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectApplyMemberDTO {

    private ApplyStatus applyStatus;
}
