package sansam.team.project.command.mapper;

import sansam.team.project.command.application.dto.AdminProjectApplyMemberDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;

public class ProjectApplyMemberMapper {
    public static ProjectApplyMember toEntity(Long userSeq, Long projectBoardSeq, AdminProjectApplyMemberDTO applyMemberDTO) {

        return ProjectApplyMember.createEntity(
                applyMemberDTO.getApplyStatus(),
                userSeq,
                projectBoardSeq
        );

    }
}
