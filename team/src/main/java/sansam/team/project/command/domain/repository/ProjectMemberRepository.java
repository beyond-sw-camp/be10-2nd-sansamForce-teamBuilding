package sansam.team.project.command.domain.repository;

import sansam.team.project.command.domain.aggregate.entity.ProjectMember;

public interface ProjectMemberRepository {

    ProjectMember save(ProjectMember projectMember);
}
