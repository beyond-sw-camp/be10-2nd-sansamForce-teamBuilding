package sansam.team.team.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.team.query.dto.TeamChatDTO;
import sansam.team.team.query.dto.TeamChatQueryDTO;

import java.util.List;

@Mapper
public interface TeamChatQueryMapper {
    List<TeamChatDTO> selectChatRoomList(TeamChatQueryDTO teamChatQueryDTO);
}
