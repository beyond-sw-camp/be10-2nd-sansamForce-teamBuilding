package sansam.team.team.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.team.query.dto.TeamBuildingRuleQueryDTO;

import java.util.List;

@Mapper
public interface TeamBuildingRuleQueryMapper {

    TeamBuildingRuleQueryDTO findById(long ruleSeq);

    List<TeamBuildingRuleQueryDTO> findAll();
}
