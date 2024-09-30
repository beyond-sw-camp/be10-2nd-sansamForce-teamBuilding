package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ApiResponse;
import sansam.team.common.response.ResponseUtil;
import sansam.team.team.command.application.dto.TeamCreateRequest;
import sansam.team.team.command.application.dto.TeamUpdateRequest;
import sansam.team.team.command.application.service.TeamService;
import sansam.team.team.command.domain.aggregate.entity.Team;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
@Tag(name = "Team API", description = "팀 API")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    @Operation(summary = "팀 추가 (팀 빌딩 이후 시스템 추가)", description = "반환한 팀 정보를 갖고 팀 채팅방을 생성한다.")
    public ApiResponse<Team> createTeam(@RequestBody TeamCreateRequest request) {
        Team team = teamService.createTeam(request);

        return ResponseUtil.successResponse(team).getBody();
    }

    @PutMapping("/{teamSeq}")
    @Operation(summary = "팀 이름, 팀 빌딩 규칙 변경")
    public ApiResponse<Team> updateTeam(@PathVariable Long teamSeq, @RequestBody TeamUpdateRequest request) {
        Team team = teamService.updateTeam(teamSeq, request);

        return ResponseUtil.successResponse(team).getBody();
    }

    @DeleteMapping("/{teamSeq}")
    public ApiResponse<String> deleteTeam(@PathVariable Long teamSeq) {
        teamService.deleteTeam(teamSeq);

        return ResponseUtil.successResponse("삭제 성공").getBody();
    }

}
