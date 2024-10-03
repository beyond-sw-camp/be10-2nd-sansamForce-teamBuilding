package com.sansam.team.command.domain.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamMemberSchedule;

import java.util.Optional;

public interface TeamMemberScheduleRepository {

    void deleteById(long memberScheduleSeq);

    TeamMemberSchedule save(TeamMemberSchedule map);

    Optional<TeamMemberSchedule> findById(long memberScheduleSeq);
}
