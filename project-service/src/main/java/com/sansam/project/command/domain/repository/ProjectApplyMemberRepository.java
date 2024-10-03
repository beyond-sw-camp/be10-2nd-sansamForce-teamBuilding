package com.sansam.project.command.domain.repository;


import com.sansam.project.command.domain.aggregate.entity.ProjectApplyMember;

import java.util.Optional;

public interface ProjectApplyMemberRepository {

    Optional<ProjectApplyMember> findById(Long applyMemberSeq);

    ProjectApplyMember save(ProjectApplyMember projectApplyMember);

    void deleteById(Long projectBoardSeq);


}