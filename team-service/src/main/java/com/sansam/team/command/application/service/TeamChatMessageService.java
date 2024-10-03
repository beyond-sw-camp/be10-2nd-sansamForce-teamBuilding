package com.sansam.team.command.application.service;


import com.sansam.team.command.application.dto.TeamChatMessageCreateRequest;
import com.sansam.team.common.mongo.MongoDBSequenceCreator;
import com.sansam.team.common.websocket.WebSocketClient;
import com.sansam.team.common.websocket.dto.TeamChatMessageDTO;
import com.sansam.team.common.websocket.dto.TeamChatMessageType;
import com.sansam.team.exception.CustomException;
import com.sansam.team.exception.ErrorCodeType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void deleteTeamChatMessage(Long teamSeq, Long teamChatMessageSeq) {
        try {
            Query query = new Query(Criteria.where("teamChatMessageSeq").is(teamChatMessageSeq).and("teamSeq").is(teamSeq));
            mongoTemplate.remove(query, "chat");
        } catch (Exception e) {
            throw new CustomException(ErrorCodeType.MONGO_ERROR);
        }
    }
}
