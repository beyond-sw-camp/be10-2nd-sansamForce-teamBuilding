package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ApiResponse;
import sansam.team.team.command.application.dto.TeamCreateRequestDTO;
import sansam.team.team.command.application.dto.TeamScheduleDTO;
import sansam.team.team.command.application.dto.TeamUpdateRequestDTO;
import sansam.team.team.command.application.service.TeamService;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.aggregate.entity.TeamSchedule;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
@Tag(name = "Team API", description = "팀 API")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    @Operation(summary = "팀 추가 (팀 빌딩 이후 시스템 추가)", description = "반환한 팀 정보를 갖고 팀 채팅방을 생성한다.")
    public ResponseEntity<Team> createTeam(@RequestBody TeamCreateRequestDTO teamDTO) {
        Team team = teamService.createTeam(teamDTO);

        return ResponseEntity.ok(team);
    }

    @PutMapping("/{teamSeq}")
    @Operation(summary = "팀 이름, 팀 빌딩 규칙 변경")
    public ResponseEntity<Team> updateTeam(@PathVariable Long teamSeq, @RequestBody TeamUpdateRequestDTO teamDTO) {
        Team team = teamService.updateTeam(teamSeq, teamDTO);

        return ResponseEntity.ok(team);
    }

    @DeleteMapping("/{teamSeq}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamSeq) {
        teamService.deleteTeam(teamSeq);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createSchedule")
    @Operation(summary = "팀 일정 추가")
    public ApiResponse<String> createTeamSchedule(@RequestBody TeamScheduleDTO scheduleDTO) {
        boolean result = teamService.createTeamSchedule(scheduleDTO);

        return result ? ApiResponse.ofSuccess("팀 일정 추가 성공") : ApiResponse.ofFailure("팀 일정 추가 실패", null);
    }

    @PutMapping("/{scheduleSeq}")
    @Operation(summary = "팀 일정 수정")
    public ApiResponse<TeamSchedule> updateTeamSchedule(@PathVariable long scheduleSeq, @RequestBody TeamScheduleDTO scheduleDTO) {
        TeamSchedule teamSchedule = teamService.updateTeamSchedule(scheduleSeq, scheduleDTO);

        return ApiResponse.ofSuccess(teamSchedule);
    }

    @DeleteMapping("/{scheduleSeq}")
    @Operation(summary = "팀 일정 삭제")
    public ApiResponse<String> deleteTeamSchedule(@PathVariable long scheduleSeq) {
        teamService.deleteTeamSchedule(scheduleSeq);

        return ApiResponse.ofSuccess("팀 일정 삭제 성공");
    }

}
