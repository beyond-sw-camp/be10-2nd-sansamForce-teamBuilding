package sansam.team.team.command.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import sansam.team.common.websocket.WebSocketClient;
import sansam.team.team.command.application.dto.TeamChatCreateRequest;
import sansam.team.team.command.application.dto.TeamChatUpdateRequest;
import sansam.team.team.command.domain.aggregate.entity.TeamChat;
import sansam.team.team.command.domain.repository.TeamChatRepository;
import sansam.team.team.command.mapper.TeamChatMapper;

@Service
@RequiredArgsConstructor
public class TeamChatService {

    private final TeamChatRepository teamChatRepository;
    private final WebSocketClient webSocketClient;

    @Transactional
    public TeamChat createTeamChat(Long teamSeq, TeamChatCreateRequest request) {
        TeamChat teamChat = TeamChatMapper.toEntity(teamSeq, request);

        teamChatRepository.save(teamChat);

        return teamChat;
    }

    @Transactional
    public TeamChat updateTeamChat(Long teamChatSeq, TeamChatUpdateRequest request) {
        TeamChat teamChat = teamChatRepository.findById(teamChatSeq).orElseThrow();

        teamChat.modifyTeamChat(request.getTeamChatName(), request.getTeamChatComment());

        return teamChat;
    }

    public void leaveTeamChat(Long teamChatSeq, Long teamMemberSeq) {
        webSocketClient.leaveChatRoom();
    }
}
