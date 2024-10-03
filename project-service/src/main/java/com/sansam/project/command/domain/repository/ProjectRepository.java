package com.sansam.project.command.domain.repository;


import com.sansam.project.command.domain.aggregate.entity.Project;

import java.util.Optional;

public interface ProjectRepository {

    Project save(Project project);

    Optional<Project> findById(Long projectSeq);

    void deleteById(Long projectSeq);
}