package sansam.team.project.command.infrastructure.repository.mentor;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.domain.aggregate.entity.MentorReview;
import sansam.team.project.command.domain.repository.mentor.MentorReviewRepository;

public interface JpaMentorReviewRepository extends MentorReviewRepository, JpaRepository<MentorReview, Long> {

}
