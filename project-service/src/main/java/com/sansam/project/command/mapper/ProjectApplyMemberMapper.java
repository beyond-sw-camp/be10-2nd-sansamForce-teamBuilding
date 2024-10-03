package com.sansam.project.command.mapper;


import com.sansam.project.command.application.dto.AdminProjectApplyMemberDTO;
import com.sansam.project.command.domain.aggregate.entity.ProjectApplyMember;

public class ProjectApplyMemberMapper {
    public static ProjectApplyMember toEntity(Long userSeq, AdminProjectApplyMemberDTO applyMemberDTO) {

        return ProjectApplyMember.createEntity(
                applyMemberDTO.getApplyStatus(),
                applyMemberDTO.getProjectBoardSeq(),
                userSeq
        );

    }
}