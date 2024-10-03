package com.sansam.team.command.application.controller;


import com.sansam.team.command.application.dto.TeamBuildingRuleDTO;
import com.sansam.team.command.application.service.TeamBuildingRuleService;
import com.sansam.team.command.domain.aggregate.entity.TeamBuildingRule;
import com.sansam.team.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/team/building-rule")
@RequiredArgsConstructor
@Tag(name = "3-1. Building rule API", description = "팀빌딩 규칙")
public class TeamBuildingRuleController {

    private final TeamBuildingRuleService buildingRuleService;

    @PostMapping
    @Operation(summary = "팀빌딩 규칙 생성", description = "팀 빌딩 규칙 가중치 생성 API")
    public ApiResponse<TeamBuildingRule> createBuildingRule(@RequestBody TeamBuildingRuleDTO buildingRuleDTO) {
        TeamBuildingRule createdBuildingRule = buildingRuleService.createBuildingRule(buildingRuleDTO);
        return ApiResponse.ofSuccess("Building rule created successfully", createdBuildingRule);
    }

    @PutMapping("/{ruleSeq}")
    @Operation(summary = "팀빌딩 규칙 수정", description = "팀 빌딩 규칙 가중치 수정 API")
    public ApiResponse<TeamBuildingRule> updateBuildingRule(
            @PathVariable int ruleSeq,
            @RequestBody TeamBuildingRuleDTO buildingRuleDTO) {
        TeamBuildingRule updatedBuildingRule = buildingRuleService.updateBuildingRule(ruleSeq, buildingRuleDTO);
        return ApiResponse.ofSuccess("Building rule updated successfully", updatedBuildingRule);
    }

    @DeleteMapping("/{ruleSeq}")
    @Operation(summary = "팀빌딩 규칙 삭제", description = "팀 빌딩 규칙 가중치 삭제 API")
    public ApiResponse<Void> deleteBuildingRule(@PathVariable int ruleSeq) {
        buildingRuleService.deleteBuildingRule(ruleSeq);
        return ApiResponse.ofSuccess("Building rule deleted successfully");
    }
}
