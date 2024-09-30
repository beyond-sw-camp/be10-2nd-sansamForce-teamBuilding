package sansam.team.team.command.domain.repository;

import sansam.team.team.command.domain.aggregate.entity.TeamMemberSchedule;

public interface TeamMemberScheduleRepository {

    void deleteById(long memberScheduleSeq);

    TeamMemberSchedule save(TeamMemberSchedule map);
}
