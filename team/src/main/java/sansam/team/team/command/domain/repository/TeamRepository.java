package sansam.team.team.command.domain.repository;

import sansam.team.team.command.domain.aggregate.entity.Team;

import java.util.Optional;

public interface TeamRepository {
    Team save(Team team);

    Optional<Team> findById(Long teamSeq);

    void deleteById(Long teamSeq);
}
