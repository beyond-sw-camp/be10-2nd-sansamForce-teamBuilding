package sansam.team.project.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.query.dto.AdminProjectMemberAllQueryDTO;
import sansam.team.project.query.mapper.ProjectMemberMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberQueryService {

    private final ProjectMemberMapper projectMemberMapper;

    public List<AdminProjectMemberAllQueryDTO> findProjectMembers(Long projectSeq) {
        return projectMemberMapper.findProjectMembersByProjectSeq(projectSeq);
    }
}