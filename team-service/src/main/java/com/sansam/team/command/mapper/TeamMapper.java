package com.sansam.team.command.mapper;


import com.sansam.team.command.application.dto.TeamCreateRequest;
import com.sansam.team.command.domain.aggregate.entity.Team;

public class TeamMapper {
    public static Team toEntity(TeamCreateRequest request) {
        return Team.create(
                request.getProjectSeq(),
                request.getRuleSeq(),
                request.getTeamName()
        );
    }
}
