package sansam.team.team.command.domain.repository;

import sansam.team.team.command.domain.aggregate.entity.TeamReview;

public interface TeamReviewRepository {
    TeamReview save(TeamReview teamReview);
}
