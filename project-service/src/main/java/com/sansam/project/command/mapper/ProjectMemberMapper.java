package com.sansam.project.command.mapper;


import com.sansam.project.command.domain.aggregate.entity.ProjectMember;

public class ProjectMemberMapper {

    public static ProjectMember toEntity(Long userSeq, Long projectSeq) {

        return ProjectMember.createEntity(
                userSeq,
                projectSeq
        );
    }
}