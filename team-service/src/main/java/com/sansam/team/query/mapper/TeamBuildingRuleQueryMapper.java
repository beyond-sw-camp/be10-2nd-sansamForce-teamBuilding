package com.sansam.team.query.mapper;


import com.sansam.team.query.dto.TeamBuildingRuleQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamBuildingRuleQueryMapper {

    TeamBuildingRuleQueryDTO findById(long ruleSeq);

    List<TeamBuildingRuleQueryDTO> findAll();
}
