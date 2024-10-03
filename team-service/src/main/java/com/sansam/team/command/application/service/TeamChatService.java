package com.sansam.team.command.application.service;


import com.sansam.team.command.application.dto.TeamChatCreateRequest;
import com.sansam.team.command.application.dto.TeamChatUpdateRequest;
import com.sansam.team.command.domain.aggregate.entity.TeamChat;
import com.sansam.team.command.domain.repository.TeamChatRepository;
import com.sansam.team.command.mapper.TeamChatMapper;
import com.sansam.team.exception.CustomException;
import com.sansam.team.exception.ErrorCodeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamChatService {

    private final TeamChatRepository teamChatRepository;

    @Transactional
    public TeamChat createTeamChat(Long teamSeq, TeamChatCreateRequest request) {
        TeamChat teamChat = TeamChatMapper.toEntity(teamSeq, request);

        teamChatRepository.save(teamChat);

        return teamChat;
    }

    @Transactional
    public TeamChat updateTeamChat(Long teamChatSeq, TeamChatUpdateRequest request) {
        TeamChat teamChat = teamChatRepository.findById(teamChatSeq).orElseThrow(() -> new CustomException(ErrorCodeType.TEAM_CHAT_NOT_FOUND));

        teamChat.modifyTeamChat(request.getTeamChatName(), request.getTeamChatComment());

        return teamChat;
    }
}
