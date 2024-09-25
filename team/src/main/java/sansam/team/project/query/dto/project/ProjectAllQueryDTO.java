package sansam.team.project.query.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sansam.team.project.command.domain.aggregate.ProjectStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAllQueryDTO {

    private Long projectSeq;
    private String projectTitle;
    private ProjectStatus projectStatus;
    private String projectImgUrl;

}
