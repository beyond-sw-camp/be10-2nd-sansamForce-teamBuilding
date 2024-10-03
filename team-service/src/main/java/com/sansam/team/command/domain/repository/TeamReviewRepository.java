package com.sansam.team.command.domain.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamReview;

import java.util.List;
import java.util.Optional;

public interface TeamReviewRepository {
    TeamReview save(TeamReview teamReview);
    Optional<TeamReview> findById(long reviewSeq);
    void deleteById(long reviewSeq);

    List<TeamReview> findAllByReceiveMemberSeq(long userSeq);
}
