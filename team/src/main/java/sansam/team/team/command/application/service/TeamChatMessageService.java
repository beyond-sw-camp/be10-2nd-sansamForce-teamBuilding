package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import sansam.team.common.websocket.WebSocketClient;
import sansam.team.common.mongo.MongoDBSequenceCreator;
import sansam.team.common.websocket.dto.TeamChatMessageDTO;
import sansam.team.common.websocket.dto.TeamChatMessageType;
import sansam.team.team.command.application.dto.TeamChatMessageCreateRequest;

import org.springframework.data.mongodb.core.query.Query;

@Service
@RequiredArgsConstructor
public class TeamChatMessageService {

    private final MongoTemplate mongoTemplate;
    private final ModelMapper mapper;
    private final WebSocketClient webSocketClient;
    private final MongoDBSequenceCreator sequenceCreator;

    public void createTeamChatMessage(TeamChatMessageCreateRequest request) {
        TeamChatMessageDTO teamChatMessage = mapper.map(request, TeamChatMessageDTO.class);
        teamChatMessage.setMessageType(TeamChatMessageType.TALK);
        teamChatMessage.setTeamChatMessageSeq(sequenceCreator.createSeq("teamChatMessageSeq"));

        mongoTemplate.insert(teamChatMessage);

        webSocketClient.sendMessage(teamChatMessage);
    }

    public void deleteTeamChatMessage(Long teamChatMessageSeq) {
        Query query = new Query(Criteria.where("teamChatMessageSeq").is(teamChatMessageSeq));
        mongoTemplate.remove(query, "chat");
    }
}
