package sansam.team.project.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.domain.repository.ProjectBoardRepository;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;

public interface JpaProjectBoardRepository extends ProjectBoardRepository, JpaRepository<ProjectBoard, Long> {
}
