package sansam.team.team.command.mapper;

import sansam.team.team.command.application.dto.TeamChatCreateRequest;
import sansam.team.team.command.domain.aggregate.entity.TeamChat;

public class TeamChatMapper {
    public static TeamChat toEntity(Long teamSeq, TeamChatCreateRequest request) {
        return TeamChat.builder()
                .teamSeq(teamSeq)
                .teamChatName(request.getTeamChatName())
                .teamChatComment(request.getTeamChatComment())
                .teamChatActive(request.getTeamChatActive())
                .build();
    }
}
