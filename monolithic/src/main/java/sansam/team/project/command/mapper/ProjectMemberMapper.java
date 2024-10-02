package sansam.team.project.command.mapper;

import sansam.team.project.command.domain.aggregate.entity.ProjectMember;

public class ProjectMemberMapper {

    public static ProjectMember toEntity(Long userSeq, Long projectSeq) {

        return ProjectMember.createEntity(
                userSeq,
                projectSeq
        );
    }
}
