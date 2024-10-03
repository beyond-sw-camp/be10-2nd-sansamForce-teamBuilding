package com.sansam.team.query.mapper;


import com.sansam.team.query.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamChatQueryMapper {
    List<TeamChatResponse> selectChatRoomList(TeamChatRequest request);

    TeamChatRoomResponse selectChatRoom(TeamChatRoomRequest request);

    TeamChatMemberResponse selectTeamMember(Long teamMemberSeq);
}
