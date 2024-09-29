package sansam.team.team.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.team.query.dto.chat.TeamChatResponse;
import sansam.team.team.query.dto.chat.TeamChatRequest;
import sansam.team.team.query.dto.chat.TeamChatRoomResponse;
import sansam.team.team.query.dto.chat.TeamChatRoomRequest;

import java.util.List;

@Mapper
public interface TeamChatQueryMapper {
    List<TeamChatResponse> selectChatRoomList(TeamChatRequest request);

    TeamChatRoomResponse selectChatRoom(TeamChatRoomRequest request);
}
