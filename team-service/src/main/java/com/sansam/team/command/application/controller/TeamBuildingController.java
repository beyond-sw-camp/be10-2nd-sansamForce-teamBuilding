package com.sansam.team.command.application.controller;


import com.sansam.team.command.application.dto.TeamMemberUpdateRequest;
import com.sansam.team.command.application.service.TeamBuildingService;
import com.sansam.team.command.application.service.TeamMemberService;
import com.sansam.team.command.domain.aggregate.entity.Team;
import com.sansam.team.command.domain.aggregate.entity.TeamMember;
import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.common.response.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/team/build")
@RequiredArgsConstructor
@Tag(name = "3-2. Team Building API", description = "팀빌딩 API")
public class TeamBuildingController {

    private final TeamBuildingService teamBuildingService;
    private final TeamMemberService teamMemberService;

    // 팀 빌딩 요청
    @PostMapping
    @Operation(summary = "프로젝트 자동 팀 빌딩")
    public ApiResponse<?> buildTeams(@RequestParam Long projectSeq , @RequestParam int teamBuildingRuleSeq) throws IOException {
        try{
            List<Team> teams = teamBuildingService.buildBalancedTeams(projectSeq ,teamBuildingRuleSeq);
            return ResponseUtil.successResponse("팀 빌딩 성공",teams).getBody();
        } catch (IllegalArgumentException e){
            return ResponseUtil.failureResponse(e.getMessage(), "PROJECT_SEQ_NULL").getBody();
        } catch (Exception e){
            return ResponseUtil.failureResponse(e.getMessage(), "TEAM_BUILDING_ERROR").getBody();
        }
    }

    @PutMapping("/{teamMemberSeq}")
    @Operation(summary = "프로젝트 수동 팀 빌딩(팀멤버 수정)")
    public ApiResponse<?> updateTeamMember(@PathVariable Long teamMemberSeq, @RequestBody TeamMemberUpdateRequest request) {
        try{
            TeamMember teamMember = teamMemberService.updateTeamMember(teamMemberSeq, request);
            return ResponseUtil.successResponse("팀 멤버 수정 성공",teamMember).getBody();
        } catch (IllegalArgumentException e){
            return ResponseUtil.failureResponse(e.getMessage(), "TEAM_MEMBER_NOT_FOUND").getBody();
        } catch (Exception e){
            return ResponseUtil.failureResponse(e.getMessage(), "UPDATE_TEAM_MEMBER_ERROR").getBody();
        }
    }

}
