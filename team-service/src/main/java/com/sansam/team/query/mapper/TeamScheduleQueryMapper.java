package com.sansam.team.query.mapper;


import com.sansam.team.query.dto.TeamScheduleQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamScheduleQueryMapper {
    List<TeamScheduleQueryDTO> selectTeamScheduleList(long teamSeq);
}
