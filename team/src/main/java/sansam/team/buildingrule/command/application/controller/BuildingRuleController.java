package sansam.team.buildingrule.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.buildingrule.command.application.dto.BuildingRuleDTO;
import sansam.team.buildingrule.command.application.service.BuildingRuleService;
import sansam.team.buildingrule.command.domain.aggregate.BuildingRule;
import sansam.team.common.response.ResponseUtil;
import sansam.team.common.response.ApiResponse;

@RestController
@RequestMapping("/api/v1/building-rules/api")
@RequiredArgsConstructor
@Tag(name = "building rule API", description = "팀빌딩 규칙")
public class BuildingRuleController {

    private final BuildingRuleService buildingRuleService;

    @PostMapping
    @Operation(summary = "팀빌딩 규칙 생성", description = "팀 빌딩 규칙 가중치 생성 API")
    public ResponseEntity<ApiResponse<BuildingRule>> createBuildingRule(@RequestBody BuildingRuleDTO buildingRuleDTO) {
        BuildingRule createdBuildingRule = buildingRuleService.createBuildingRule(buildingRuleDTO);
        return ResponseUtil.successResponse("Building rule created successfully", createdBuildingRule);
    }

    @PutMapping("/{ruleSeq}")
    @Operation(summary = "팀빌딩 규칙 수정", description = "팀 빌딩 규칙 가중치 수정 API")
    public ResponseEntity<ApiResponse<BuildingRule>> updateBuildingRule(
            @PathVariable int ruleSeq,
            @RequestBody BuildingRuleDTO buildingRuleDTO) {
        BuildingRule updatedBuildingRule = buildingRuleService.updateBuildingRule(ruleSeq, buildingRuleDTO);
        return ResponseUtil.successResponse("Building rule updated successfully", updatedBuildingRule);
    }

    @DeleteMapping("/{ruleSeq}")
    @Operation(summary = "팀빌딩 규칙 삭제", description = "팀 빌딩 규칙 가중치 삭제 API")
    public ResponseEntity<ApiResponse<Void>> deleteBuildingRule(@PathVariable int ruleSeq) {
        buildingRuleService.deleteBuildingRule(ruleSeq);
        return ResponseUtil.successResponse("Building rule deleted successfully", null);
    }
}
