package sansam.team.team.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.team.query.dto.TeamBuildingRuleQueryDTO;
import sansam.team.team.query.mapper.TeamBuildingRuleQueryMapper;

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
