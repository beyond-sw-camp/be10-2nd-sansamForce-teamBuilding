package sansam.team.team.command.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;
import sansam.team.common.websocket.WebSocketClient;
import sansam.team.common.mongo.MongoDBSequenceCreator;
import sansam.team.common.websocket.dto.TeamChatMessageDTO;
import sansam.team.common.websocket.dto.TeamChatMessageType;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.application.dto.TeamChatMessageCreateRequest;

import org.springframework.data.mongodb.core.query.Query;

@Service
@RequiredArgsConstructor
public class TeamChatMessageService {

    private final MongoTemplate mongoTemplate;
    private final ModelMapper mapper;
    private final WebSocketClient webSocketClient;
    private final MongoDBSequenceCreator sequenceCreator;

    @Transactional
    public void createTeamChatMessage(TeamChatMessageCreateRequest request) {
        TeamChatMessageDTO teamChatMessage = mapper.map(request, TeamChatMessageDTO.class);
        teamChatMessage.setMessageType(TeamChatMessageType.TALK);
        teamChatMessage.setTeamChatMessageSeq(sequenceCreator.createSeq("teamChatMessageSeq"));

        try {
            mongoTemplate.insert(teamChatMessage);
        } catch (Exception e) {
            throw new CustomException(ErrorCodeType.MONGO_ERROR);
        }

        try {
            webSocketClient.sendMessage(teamChatMessage);
        } catch (Exception e) {
            throw new CustomException(ErrorCodeType.WEB_SOCKET_ERROR);
        }
    }

    @Transactional
    public void deleteTeamChatMessage(Long teamChatMessageSeq) {
        try {
            Query query = new Query(Criteria.where("teamChatMessageSeq").is(teamChatMessageSeq));
            mongoTemplate.remove(query, "chat");
        } catch (Exception e) {
            throw new CustomException(ErrorCodeType.MONGO_ERROR);
        }
    }
}
