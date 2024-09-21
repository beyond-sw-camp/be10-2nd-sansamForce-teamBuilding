package sansam.team.project.command.domain.repository;

import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;

import java.util.Optional;

public interface ProjectApplyMemberRepository {
    ProjectApplyMember save(ProjectApplyMember projectApplyMember);

    void deleteById(Long projectBoardSeq);
}
