package sansam.team.project.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.project.command.domain.aggregate.entity.MentorReview;
import sansam.team.project.command.domain.repository.ProjectMentorReviewRepository;

public interface JpaProjectMentorReviewRepository extends ProjectMentorReviewRepository, JpaRepository<MentorReview, Long> {

}