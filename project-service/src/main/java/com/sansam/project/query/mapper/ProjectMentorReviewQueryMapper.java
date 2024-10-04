package com.sansam.project.query.mapper;


import com.sansam.project.query.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMentorReviewQueryMapper {
    List<ProjectMentorReviewAllQueryDTO> findAllForMentor();

    ProjectMentorReviewQueryDTO findByIdForMentor(Long mentorReviewSeq);

    ProjectMentorReviewUserQueryDTO findByIdForUser(Long mentorReviewSeq);

    List<ProjectMentorReviewAllUserQueryDTO> findAllByIdForUser();

    List<ProjectMentorReviewDTO> findProjectMentorReviewByProjectMember(Long projectMemberSeq);
}