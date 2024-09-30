package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ApiResponse;
import sansam.team.common.response.ResponseUtil;
import sansam.team.team.command.application.dto.TeamMemberUpdateRequest;
import sansam.team.team.command.application.dto.TeamUpdateRequest;
import sansam.team.team.command.application.service.TeamBuildingService;
import sansam.team.team.command.application.service.TeamMemberService;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.aggregate.entity.TeamMember;

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
    public ApiResponse<List<Team>> buildTeams(@RequestParam Long projectSeq , @RequestParam int teamBuildingRuleSeq) throws IOException {
        List<Team> teams = teamBuildingService.buildBalancedTeams(projectSeq ,teamBuildingRuleSeq);
        return ResponseUtil.successResponse("팀 빌딩 성공",teams).getBody();
    }

    @PutMapping("/{teamMemberSeq}")
    @Operation(summary = "프로젝트 수동 팀 빌딩(팀멤버 수정)")
    public ApiResponse<TeamMember> updateTeamMember(@PathVariable Long teamMemberSeq, @RequestBody TeamMemberUpdateRequest request) {
        TeamMember teamMember = teamMemberService.updateTeamMember(teamMemberSeq, request);

        return ResponseUtil.successResponse(teamMember).getBody();
    }

}
