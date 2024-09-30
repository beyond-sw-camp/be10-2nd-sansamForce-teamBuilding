package sansam.team.project.command.domain.repository;

import sansam.team.project.command.domain.aggregate.entity.MentorReview;

import java.util.Optional;

public interface ProjectMentorReviewRepository {

    MentorReview save(MentorReview mentorReview);

    Optional<MentorReview> findById(Long mentorReviewSeq);

    void delete(MentorReview mentorReview);

}
