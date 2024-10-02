package sansam.team.team.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sansam.team.team.query.dto.TeamFindByIdResponse;
import sansam.team.team.query.dto.TeamRequest;
import sansam.team.team.query.dto.TeamResponse;

@Mapper
public interface TeamQueryMapper {
    TeamResponse selectTeamList(TeamRequest teamRequest);

    TeamFindByIdResponse selectTeamById(@Param("teamSeq") Long teamSeq);
}
