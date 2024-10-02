package sansam.team.team.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.domain.aggregate.entity.TeamReview;
import sansam.team.team.command.domain.repository.TeamReviewRepository;

public interface JpaTeamReviewRepository extends TeamReviewRepository, JpaRepository<TeamReview, Long> {
}
