package com.sansam.team.command.mapper;


import com.sansam.team.command.application.dto.TeamChatCreateRequest;
import com.sansam.team.command.domain.aggregate.entity.TeamChat;

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
