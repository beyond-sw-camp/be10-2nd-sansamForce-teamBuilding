package com.sansam.project.command.infrastructure.repository;


import com.sansam.project.command.domain.aggregate.entity.ProjectBoard;
import com.sansam.project.command.domain.repository.ProjectBoardRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectBoardRepository extends ProjectBoardRepository, JpaRepository<ProjectBoard, Long> {
}