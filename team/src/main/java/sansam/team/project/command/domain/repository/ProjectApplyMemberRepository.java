package sansam.team.project.command.domain.repository;

import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;

import java.util.Optional;

public interface ProjectApplyMemberRepository {

    Optional<ProjectApplyMember> findByUser_UserSeqAndProjectBoard_ProjectBoardSeq(Long userSeq, Long projectBoardSeq);

}
