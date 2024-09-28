package sansam.team.buildingrule.command.domain.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.buildingrule.command.domain.application.service.BuildingRuleService;
import sansam.team.buildingrule.command.domain.domain.aggregate.BuildingRule;

@RestController
@RequestMapping("/api/building-rules")
@RequiredArgsConstructor
public class BuildingRuleController {

    private final BuildingRuleService buildingRuleService;

    @PostMapping
    public ResponseEntity<BuildingRule> createBuildingRule(@RequestBody BuildingRule buildingRule) {
        BuildingRule createdBuildingRule = buildingRuleService.createBuildingRule(buildingRule);
        return ResponseEntity.ok(createdBuildingRule);
    }

    @PutMapping("/{ruleSeq}")
    public ResponseEntity<BuildingRule> updateBuildingRule(
            @PathVariable int ruleSeq,
            @RequestBody BuildingRule buildingRule) {
        BuildingRule updatedBuildingRule = buildingRuleService.updateBuildingRule(ruleSeq, buildingRule);
        return ResponseEntity.ok(updatedBuildingRule);
    }

    @DeleteMapping("/{ruleSeq}")
    public ResponseEntity<Void> deleteBuildingRule(@PathVariable int ruleSeq) {
        buildingRuleService.deleteBuildingRule(ruleSeq);
        return ResponseEntity.noContent().build();
    }
}

