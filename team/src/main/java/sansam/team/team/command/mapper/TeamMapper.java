package sansam.team.team.command.mapper;

import sansam.team.team.command.application.dto.TeamCreateRequestDTO;
import sansam.team.team.command.domain.aggregate.entity.Team;

public class TeamMapper {
    public static Team toEntity(TeamCreateRequestDTO createRequest) {
        return Team.create(
                createRequest.getProjectSeq(),
                createRequest.getRuleSeq(),
                createRequest.getTeamName()
        );
    }
}
