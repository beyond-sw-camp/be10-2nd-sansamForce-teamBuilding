package sansam.team.project.command.infrastructure.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.domain.repository.project.ProjectRepository;
import sansam.team.project.command.domain.aggregate.entity.Project;

public interface JpaProjectRepository extends ProjectRepository, JpaRepository<Project, Long> {

}
