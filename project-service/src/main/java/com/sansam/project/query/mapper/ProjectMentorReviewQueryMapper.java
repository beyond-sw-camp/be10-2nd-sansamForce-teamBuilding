package com.sansam.project.query.mapper;


import com.sansam.project.query.dto.ProjectMentorReviewAllQueryDTO;
import com.sansam.project.query.dto.ProjectMentorReviewAllUserQueryDTO;
import com.sansam.project.query.dto.ProjectMentorReviewQueryDTO;
import com.sansam.project.query.dto.ProjectMentorReviewUserQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMentorReviewQueryMapper {
    List<ProjectMentorReviewAllQueryDTO> findAllForMentor();

    ProjectMentorReviewQueryDTO findByIdForMentor(Long mentorReviewSeq);

    ProjectMentorReviewUserQueryDTO findByIdForUser(Long mentorReviewSeq);

    List<ProjectMentorReviewAllUserQueryDTO> findAllByIdForUser();
}