package com.sansam.team.query.service;


import com.sansam.team.query.dto.TeamBuildingRuleQueryDTO;
import com.sansam.team.query.mapper.TeamBuildingRuleQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamBuildingRuleQueryService {

    private final TeamBuildingRuleQueryMapper buildingRuleQueryMapper;

    public TeamBuildingRuleQueryDTO findById(long ruleSeq) {
        return buildingRuleQueryMapper.findById(ruleSeq);
    }

    public List<TeamBuildingRuleQueryDTO> findAll() {
        return buildingRuleQueryMapper.findAll();
    }
}
