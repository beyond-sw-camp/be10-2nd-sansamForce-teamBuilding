package com.sansam.project.command.infrastructure.repository;

import com.sansam.project.command.domain.aggregate.entity.MentorReview;
import com.sansam.project.command.domain.repository.ProjectMentorReviewRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProjectMentorReviewRepository extends ProjectMentorReviewRepository, JpaRepository<MentorReview, Long> {

}