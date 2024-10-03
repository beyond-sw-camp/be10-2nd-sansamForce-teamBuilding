package com.sansam.team.command.infrastructure.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamReview;
import com.sansam.team.command.domain.repository.TeamReviewRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeamReviewRepository extends TeamReviewRepository, JpaRepository<TeamReview, Long> {
}
