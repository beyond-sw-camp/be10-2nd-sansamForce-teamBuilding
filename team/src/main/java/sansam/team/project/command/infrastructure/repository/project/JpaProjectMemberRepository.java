package sansam.team.project.command.infrastructure.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;
import sansam.team.project.command.domain.repository.project.ProjectMemberRepository;

public interface JpaProjectMemberRepository extends ProjectMemberRepository, JpaRepository<ProjectMember, Long> {

}
