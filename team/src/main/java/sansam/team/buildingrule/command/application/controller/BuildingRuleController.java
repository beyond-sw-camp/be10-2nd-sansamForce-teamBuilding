package sansam.team.buildingrule.command.application.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.buildingrule.command.application.dto.BuildingRuleDTO;
import sansam.team.buildingrule.command.application.service.BuildingRuleService;
import sansam.team.buildingrule.command.domain.aggregate.BuildingRule;

@RestController
@RequestMapping("/api/building-rules")
@RequiredArgsConstructor
public class BuildingRuleController {

    private final BuildingRuleService buildingRuleService;

    @PostMapping
    public ResponseEntity<BuildingRule> createBuildingRule(@RequestBody BuildingRuleDTO buildingRuleDTO) {
        BuildingRule createdBuildingRule = buildingRuleService.createBuildingRule(buildingRuleDTO);
        return ResponseEntity.ok(createdBuildingRule);
    }

    @PutMapping("/{ruleSeq}")
    public ResponseEntity<BuildingRule> updateBuildingRule(
            @PathVariable int ruleSeq,
            @RequestBody BuildingRuleDTO buildingRuleDTO) {
        BuildingRule updatedBuildingRule = buildingRuleService.updateBuildingRule(ruleSeq, buildingRuleDTO);
        return ResponseEntity.ok(updatedBuildingRule);
    }

    @DeleteMapping("/{ruleSeq}")
    public ResponseEntity<Void> deleteBuildingRule(@PathVariable int ruleSeq) {
        buildingRuleService.deleteBuildingRule(ruleSeq);
        return ResponseEntity.noContent().build();
    }
}
