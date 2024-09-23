package sansam.team.team.command.application.controller.teamBuilding;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.team.command.application.service.teamBuilding.TeamBuildingService;
import sansam.team.team.command.domain.aggregate.entity.Team;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teamBuilding")
@RequiredArgsConstructor
@Tag(name = "TeamBuilding API", description = "팀빌딩 API")
public class TeamBuildingController {
    @Autowired
    private TeamBuildingService teamBuildingService;

    // 팀 빌딩 요청
    @PostMapping("/build")
    public ResponseEntity<List<Team>> buildTeams(@RequestBody List<ProjectApplyMember> pjMembers) {
        List<Team> teams = teamBuildingService.buildBalancedTeams(pjMembers);
        return ResponseEntity.ok(teams);
    }

    // 사용자 점수 계산
    @PostMapping("/calculate-scores")
    public ResponseEntity<Void> calculateUserScores(List<ProjectApplyMember> pjMembers) {
        // 사용자 점수를 계산하고 저장
        for (ProjectApplyMember pjMember : pjMembers) {
            int score = teamBuildingService.calculateTotalScore(pjMember);
            teamBuildingService.saveUserScore(pjMember, score);
        }
        return ResponseEntity.ok().build();
    }

}


