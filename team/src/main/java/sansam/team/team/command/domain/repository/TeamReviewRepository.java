package sansam.team.team.command.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.domain.aggregate.entity.TeamReview;

public interface TeamReviewRepository extends JpaRepository<TeamReview, Long> {
}
