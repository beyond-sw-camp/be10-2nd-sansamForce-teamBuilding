package sansam.team.project.command.domain.repository.project;

import sansam.team.project.command.domain.aggregate.entity.ProjectMember;

import java.util.Optional;

public interface ProjectMemberRepository {

    ProjectMember save(ProjectMember projectMember);

    Optional<ProjectMember> findById(Long projectMemberSeq);
}
