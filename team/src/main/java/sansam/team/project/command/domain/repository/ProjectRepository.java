package sansam.team.project.command.domain.repository;

import sansam.team.project.command.domain.aggregate.entity.Project;

public interface ProjectRepository {

    Project save(Project project);
}
