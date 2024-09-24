package sansam.team.project.query.mapper;

import sansam.team.project.query.dto.project.ProjectAdminQueryDTO;
import sansam.team.project.query.dto.project.ProjectAllQueryDTO;
import sansam.team.project.query.dto.project.ProjectUserQueryDTO;

import java.util.List;

public interface ProjectMapper {

    List<ProjectAllQueryDTO> findAllProjectForAdmin();

    List<ProjectAllQueryDTO> findAllProjectForUser();

    ProjectAdminQueryDTO findProjectByIdForAdmin(Long projectSeq);

    ProjectUserQueryDTO findProjectByIdForUser(Long projectSeq);


}
