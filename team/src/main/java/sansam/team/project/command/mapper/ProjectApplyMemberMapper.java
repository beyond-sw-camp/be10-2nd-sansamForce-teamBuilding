package sansam.team.project.command.mapper;

import sansam.team.project.command.application.dto.board.ProjectApplyMemberDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;

public class ProjectApplyMemberMapper {
    public static ProjectApplyMember toEntity(Long userSeq, Long projectBoardSeq, ProjectApplyMemberDTO applyMemberDTO) {

        return ProjectApplyMember.createEntity(
                applyMemberDTO.getApplyStatus(),
                userSeq,
                projectBoardSeq
        );

    }
}
