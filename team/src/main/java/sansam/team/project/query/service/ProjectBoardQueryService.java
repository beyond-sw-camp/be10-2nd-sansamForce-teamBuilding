package sansam.team.project.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.query.dto.ProjectBoardQueryDTO;
import sansam.team.project.query.mapper.ProjectBoardMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectBoardQueryService {

    private final ProjectBoardMapper projectBoardMapper;

    public List<ProjectBoardQueryDTO> getAllProjectBoards(){
        return projectBoardMapper.findAll();
    }

    public ProjectBoardQueryDTO getProjectBoardById(Long projectBoardSeq) {
        return projectBoardMapper.findById(projectBoardSeq);
    }
}
