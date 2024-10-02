package sansam.team.team.command.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.application.dto.TeamChatCreateRequest;
import sansam.team.team.command.application.dto.TeamChatUpdateRequest;
import sansam.team.team.command.domain.aggregate.entity.TeamChat;
import sansam.team.team.command.domain.repository.TeamChatRepository;
import sansam.team.team.command.mapper.TeamChatMapper;

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
