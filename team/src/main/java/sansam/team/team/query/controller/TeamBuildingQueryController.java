package sansam.team.team.query.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sansam.team.team.command.domain.aggregate.entity.Team;

import java.util.List;

public class TeamBuildingQueryController {
    // 3. 생성된 팀 정보 반환
    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getTeams() {
        // 저장된 팀 정보 조회
        List<Team> teams = teamBuildingService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    // 4. 특정 사용자 점수 조회 (옵션)
    @GetMapping("/user-score/{userId}")
    public ResponseEntity<Integer> getUserScore(@PathVariable Long userId) {
        // 특정 사용자의 팀 빌딩 점수 조회
        int score = teamBuildingService.getUserScore(userId);
        return ResponseEntity.ok(score);
    }
}
