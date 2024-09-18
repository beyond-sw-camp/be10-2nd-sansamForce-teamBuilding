package sansam.team.project.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.entity.ProjectApplyMember;

import java.util.Optional;

public interface ProjectApplyMemberRepository extends JpaRepository<ProjectApplyMember, Long> {

    Optional<ProjectApplyMember> findByUser_UserSeqAndProjectBoard_ProjectBoardSeq(Long userSeq, Long projectBoardSeq);
}
