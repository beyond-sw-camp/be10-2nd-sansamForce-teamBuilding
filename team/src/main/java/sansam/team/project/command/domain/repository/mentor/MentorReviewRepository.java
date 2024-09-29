package sansam.team.project.command.domain.repository.mentor;

import sansam.team.project.command.domain.aggregate.entity.MentorReview;

public interface MentorReviewRepository {

    MentorReview save(MentorReview mentorReview);
}
