package com.sansam.team.command.domain.repository;

import com.sansam.team.command.domain.aggregate.entity.Team;

import java.util.Optional;

public interface TeamRepository {
    Team save(Team team);

    Optional<Team> findById(long teamSeq);

    void deleteById(long teamSeq);
}
