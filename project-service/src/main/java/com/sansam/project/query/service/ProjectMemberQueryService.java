package com.sansam.project.query.service;


import com.sansam.project.query.dto.AdminProjectMemberAllQueryDTO;
import com.sansam.project.query.mapper.ProjectMemberQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberQueryService {

    private final ProjectMemberQueryMapper projectMemberMapper;

    public List<AdminProjectMemberAllQueryDTO> findProjectMembers(Long projectSeq) {
        return projectMemberMapper.findProjectMembersByProjectSeq(projectSeq);
    }
}