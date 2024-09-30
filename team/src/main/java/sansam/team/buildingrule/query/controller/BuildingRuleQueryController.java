package sansam.team.buildingrule.query.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sansam.team.buildingrule.query.dto.BuildingRuleQueryDTO;
import sansam.team.buildingrule.query.service.BuildingRuleQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/building-rule")
@RequiredArgsConstructor
public class BuildingRuleQueryController {

    private final BuildingRuleQueryService buildingRuleQueryService;

    @GetMapping("/{ruleSeq}")
    public BuildingRuleQueryDTO getBuildingRule(@PathVariable int ruleSeq) {
        return buildingRuleQueryService.findById(ruleSeq);
    }

    @GetMapping
    public List<BuildingRuleQueryDTO> getAllBuildingRules() {
        return buildingRuleQueryService.findAll();
    }
}
