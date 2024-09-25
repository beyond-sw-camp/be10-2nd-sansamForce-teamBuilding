package sansam.team.buildingrule.command.domain.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.buildingrule.command.domain.domain.aggregate.BuildingRule;
import sansam.team.buildingrule.command.domain.domain.repositroy.BuildingRuleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingRuleService {

    private final BuildingRuleRepository buildingRuleRepository;
    public List<BuildingRule> findAll(BuildingRule rule) {
        
    }
}
