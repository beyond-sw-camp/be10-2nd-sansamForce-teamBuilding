package sansam.team.team.query.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import sansam.team.common.jwt.SecurityUtil;
import sansam.team.common.websocket.WebSocketClient;
import sansam.team.common.websocket.dto.TeamChatMemberDTO;
import sansam.team.common.websocket.dto.TeamChatMessageDTO;
import sansam.team.team.query.dto.chat.TeamChatResponse;
import sansam.team.team.query.dto.chat.TeamChatRequest;
import sansam.team.team.query.dto.chat.TeamChatRoomRequest;
import sansam.team.team.query.dto.chat.TeamChatRoomResponse;
import sansam.team.team.query.mapper.TeamChatQueryMapper;
import sansam.team.user.command.domain.aggregate.entity.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamChatQueryService {
    private final TeamChatQueryMapper teamChatQueryMapper;
    private final MongoTemplate mongoTemplate;
    private final WebSocketClient webSocketClient;

    public List<TeamChatResponse> selectChatRoomList() {
        User user = SecurityUtil.getAuthenticatedUser();
        return teamChatQueryMapper.selectChatRoomList(new TeamChatRequest(user.getUserSeq(), user.getUserAuth()));
    }

    public TeamChatRoomResponse selectChatRoom(Long teamChatSeq) {
        User user = SecurityUtil.getAuthenticatedUser();
        TeamChatRoomResponse response = teamChatQueryMapper.selectChatRoom(new TeamChatRoomRequest(teamChatSeq, user.getUserSeq()));

        Query query = new Query(Criteria.where("teamChatSeq").is(teamChatSeq));

        List<TeamChatMessageDTO> teamChatMessageList = mongoTemplate.find(query, TeamChatMessageDTO.class, "chat");
        List<TeamChatMemberDTO> teamChatMemberList = mongoTemplate.find(query, TeamChatMemberDTO.class, "chatMember");

        query = new Query(Criteria.where("teamChatSeq")
                .is(teamChatSeq)
                .and("teamMemberSeq")
                .is(response.getTeamMemberSeq()));

        TeamChatMemberDTO teamChatMember = mongoTemplate.findOne(query, TeamChatMemberDTO.class, "chatMember");

        response.setTeamChatMessageList(teamChatMessageList);
        response.setTeamChatMemberList(teamChatMemberList);
        response.setTeamChatMember(teamChatMember);

        if(teamChatMember == null) {
            teamChatMember = new TeamChatMemberDTO(response.getTeamChatSeq(), response.getTeamMemberSeq(), response.getUserNickName());
            mongoTemplate.insert(teamChatMember);
        }

        webSocketClient.start(response);

        return response;
    }
}
