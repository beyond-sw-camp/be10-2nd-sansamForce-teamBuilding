package sansam.team.team.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.team.query.dto.chat.*;

import java.util.List;

@Mapper
public interface TeamChatQueryMapper {
    List<TeamChatResponse> selectChatRoomList(TeamChatRequest request);

    TeamChatRoomResponse selectChatRoom(TeamChatRoomRequest request);

    TeamChatMemberResponse selectTeamMember(Long teamMemberSeq);
}
