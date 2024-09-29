package sansam.team.team.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.team.query.dto.chat.*;

@Mapper
public interface TeamChatMemberQueryMapper {
    TeamChatMemberResponse selectTeamMember(Long teamMemberSeq);
}
