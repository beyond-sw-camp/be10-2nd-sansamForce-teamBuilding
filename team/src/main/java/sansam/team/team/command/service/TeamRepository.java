package sansam.team.team.command.service;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
