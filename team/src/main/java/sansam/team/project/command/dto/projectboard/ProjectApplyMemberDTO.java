package sansam.team.project.command.dto.projectboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sansam.team.project.command.enums.ApplyStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectApplyMemberDTO {

    private ApplyStatus applyStatus;
}
