package com.sansam.project.command.infrastructure.repository;

import com.sansam.project.command.domain.aggregate.entity.Project;
import com.sansam.project.command.domain.repository.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectRepository extends ProjectRepository, JpaRepository<Project, Long> {

}