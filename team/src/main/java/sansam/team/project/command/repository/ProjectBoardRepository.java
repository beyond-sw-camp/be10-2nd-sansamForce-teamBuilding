package sansam.team.project.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.entity.ProjectBoard;

public interface ProjectBoardRepository extends JpaRepository<ProjectBoard, Long> {
}
