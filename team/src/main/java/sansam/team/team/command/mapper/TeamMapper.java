package sansam.team.team.command.mapper;

import sansam.team.team.command.application.dto.TeamCreateRequest;
import sansam.team.team.command.domain.aggregate.entity.Team;

public class TeamMapper {
    public static Team toEntity(TeamCreateRequest request) {
        return Team.create(
                request.getProjectSeq(),
                request.getRuleSeq(),
                request.getTeamName()
        );
    }
}
