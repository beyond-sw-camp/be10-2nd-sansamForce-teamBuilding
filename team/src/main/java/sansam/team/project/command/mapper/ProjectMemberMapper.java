package sansam.team.project.command.mapper;

import sansam.team.project.command.application.dto.project.ProjectMemberCreateDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;

public class ProjectMemberMapper {

    public static ProjectMember toEntity(Long userSeq, Long projectSeq, ProjectMemberCreateDTO projectMemberCreateDTO) {

        return ProjectMember.createEntity(
                projectMemberCreateDTO.getProjectMemberDelYn(),
                projectMemberCreateDTO.getProjectMentorYn(),
                userSeq,
                projectSeq
        );
    }
}
