package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.team.command.application.service.TeamBuildingService;
import sansam.team.team.command.domain.aggregate.entity.Team;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/teamBuilding")
@RequiredArgsConstructor
@Tag(name = "TeamBuilding API", description = "팀빌딩 API")
public class TeamBuildingController {

    private final TeamBuildingService teamBuildingService;

    // 팀 빌딩 요청
    @PostMapping("/team_building")
    @Operation(summary = "프로젝트 내 팀 빌딩")
    public ResponseEntity<List<Team>> buildTeams(@RequestParam Long projectSeq , @RequestParam int teamBuildingRuleSeq ) throws IOException {
        List<Team> teams = teamBuildingService.buildBalancedTeams(projectSeq ,teamBuildingRuleSeq);
        return ResponseEntity.ok(teams);
    }

}
