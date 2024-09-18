package sansam.team.project.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.project.query.dto.ProjectBoardQueryDTO;

import java.util.List;

@Mapper
public interface ProjectBoardMapper {
    List<ProjectBoardQueryDTO> findAll();

    ProjectBoardQueryDTO findById(Long projectBoardSeq);
}
