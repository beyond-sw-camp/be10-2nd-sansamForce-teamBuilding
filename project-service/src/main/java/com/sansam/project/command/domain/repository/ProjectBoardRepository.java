package sansam.team.project.command.domain.repository;

import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;

import java.util.Optional;

public interface ProjectBoardRepository {
    
    ProjectBoard save(ProjectBoard projectBoard);

    Optional<ProjectBoard> findById(Long projectBoardSeq);

    void deleteById(Long projectBoardSeq);
}