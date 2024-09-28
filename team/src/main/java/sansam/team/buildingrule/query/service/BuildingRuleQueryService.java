package sansam.team.buildingrule.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.buildingrule.query.dto.BuildingRuleQueryDTO;
import sansam.team.buildingrule.query.mapper.BuildingRuleQueryMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingRuleQueryService {

    private final BuildingRuleQueryMapper buildingRuleQueryMapper;

    public BuildingRuleQueryDTO findById(int ruleSeq) {
        return buildingRuleQueryMapper.findById(ruleSeq);
    }

    public List<BuildingRuleQueryDTO> findAll() {
        return buildingRuleQueryMapper.findAll();
    }
}
