package sansam.team.project.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.domain.repository.ProjectApplyMemberRepository;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;

public interface JpaProjectApplyMemberRepository extends ProjectApplyMemberRepository, JpaRepository<ProjectApplyMember, Long> {

}
