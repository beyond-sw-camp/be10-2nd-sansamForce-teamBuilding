package sansam.team.project.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.command.domain.aggregate.entity.Project;
import sansam.team.project.query.dto.project.ProjectAllQueryDTO;
import sansam.team.project.query.mapper.ProjectMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectQueryService {

    private final ProjectMapper projectMapper;

    /* 프로젝트 전체 조회 (관리자) */
    public List<ProjectAllQueryDTO> getAllProjects() {
        return projectMapper.findAllProject();
    }

    /* 프로젝트 게시물 상세 조회 (관리자) */
    public ProjectAdminQueryDTO getProjectByIdForAdmin(Long projectSeq){
        return projectMapper.findProjectByIdForAdmin(projectSeq);
    }

    /* 프로젝트 게시물 상세 조회 (사용자) */
    public ProjectUserQueryDTO getProjectByIdForUser(Long projectSeq){
        return projectMapper.findProjectByIdForUser(projectSeq);
    }

}
