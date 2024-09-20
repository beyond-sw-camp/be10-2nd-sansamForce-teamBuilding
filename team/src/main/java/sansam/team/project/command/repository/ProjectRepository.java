package sansam.team.project.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
