package com.sansam.team.command.domain.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamSchedule;

import java.util.Optional;

public interface TeamScheduleRepository {

    TeamSchedule save(TeamSchedule teamSchedule);

    Optional<TeamSchedule> findById(long scheduleSeq);

    void deleteById(long scheduleSeq);
}
