package com.sansam.project.query.service;


import com.sansam.project.query.dto.AdminProjectQueryDTO;
import com.sansam.project.query.dto.ProjectAllQueryDTO;
import com.sansam.project.query.dto.ProjectQueryDTO;
import com.sansam.project.query.mapper.ProjectQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectQueryService {

    private final ProjectQueryMapper projectMapper;

    /* 프로젝트 전체 조회 (관리자) */
    public List<ProjectAllQueryDTO> getAllProjectsForAdmin() {
        return projectMapper.findAllProjectForAdmin();
    }

    /* 프로젝트 전체 조회 (사용자) */
    public List<ProjectAllQueryDTO> getAllProjectsForUser(Long userSeq){

        CustomUserDTO user = SecurityUtil.getAuthenticatedUser();

        if(ObjectUtils.isEmpty(user.getUserSeq())){
            throw new IllegalArgumentException("User Seq is null");
        }

        return projectMapper.findAllProjectForUser(user.getUserSeq());
    }

    /* 프로젝트 상세 조회 (관리자) */
    public AdminProjectQueryDTO getProjectByIdForAdmin(Long projectSeq){
        return projectMapper.findProjectByIdForAdmin(projectSeq);
    }

    /* 프로젝트 상세 조회 (사용자) */
    public ProjectQueryDTO getProjectByIdForUser(Long projectSeq){
        return projectMapper.findProjectByIdForUser(projectSeq);
    }

}