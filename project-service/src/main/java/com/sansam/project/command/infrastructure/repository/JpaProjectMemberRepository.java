package com.sansam.project.command.infrastructure.repository;

import com.sansam.project.command.domain.aggregate.entity.ProjectMember;
import com.sansam.project.command.domain.repository.ProjectMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectMemberRepository extends ProjectMemberRepository, JpaRepository<ProjectMember, Long> {

}