package com.sansam.team.query.mapper;

import com.sansam.team.query.dto.TeamFindByIdResponse;
import com.sansam.team.query.dto.TeamRequest;
import com.sansam.team.query.dto.TeamResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeamQueryMapper {
    TeamResponse selectTeamList(TeamRequest teamRequest);

    TeamFindByIdResponse selectTeamById(@Param("teamSeq") Long teamSeq);
}
