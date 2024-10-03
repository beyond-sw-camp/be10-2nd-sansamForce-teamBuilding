package com.sansam.team.command.application.controller;


import com.sansam.team.command.application.dto.TeamUpdateRequest;
import com.sansam.team.command.application.service.TeamService;
import com.sansam.team.command.domain.aggregate.entity.Team;
import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.common.response.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
@Tag(name = "3-3. Team API", description = "팀 API")
public class TeamController {

    private final TeamService teamService;

    @PutMapping("/{teamSeq}")
    @Operation(summary = "팀 이름, 팀 빌딩 규칙 변경")
    public ApiResponse<?> updateTeam(@PathVariable Long teamSeq, @RequestBody TeamUpdateRequest request) {
        Team team = teamService.updateTeam(teamSeq, request);

        return ResponseUtil.successResponse("팀 정보 변경 성공").getBody();
    }

    @DeleteMapping("/{teamSeq}")
    public ApiResponse<?> deleteTeam(@PathVariable Long teamSeq) {
        teamService.deleteTeam(teamSeq);

        return ResponseUtil.successResponse("삭제 성공").getBody();
    }

}
