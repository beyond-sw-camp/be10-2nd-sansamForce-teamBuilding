package com.sansam.team.query.mapper;


import com.sansam.team.query.dto.TeamChatMemberResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamChatMemberQueryMapper {
    TeamChatMemberResponse selectTeamMember(Long teamMemberSeq);
}
