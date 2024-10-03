package com.sansam.project.command.infrastructure.repository;


import com.sansam.project.command.domain.aggregate.entity.ProjectApplyMember;
import com.sansam.project.command.domain.repository.ProjectApplyMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectApplyMemberRepository extends ProjectApplyMemberRepository, JpaRepository<ProjectApplyMember, Long> {

}