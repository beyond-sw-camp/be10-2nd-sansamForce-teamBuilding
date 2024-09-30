package sansam.team.team.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.team.query.dto.TeamScheduleQueryDTO;

import java.util.List;

@Mapper
public interface TeamQueryMapper {
    List<TeamScheduleQueryDTO> selectTeamScheduleList(long teamSeq);
}
