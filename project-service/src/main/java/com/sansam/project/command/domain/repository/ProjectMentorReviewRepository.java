package com.sansam.project.command.domain.repository;


import com.sansam.project.command.domain.aggregate.entity.MentorReview;

import java.util.List;
import java.util.Optional;

public interface ProjectMentorReviewRepository {

    MentorReview save(MentorReview mentorReview);

    Optional<MentorReview> findById(Long mentorReviewSeq);

    void delete(MentorReview mentorReview);

    List<MentorReview> findAllByProjectMemberSeq(Long projectMemberSeq);

}