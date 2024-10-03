package com.sansam.team.command.application.controller;


import com.sansam.team.command.application.dto.TeamScheduleDTO;
import com.sansam.team.command.application.service.TeamScheduleService;
import com.sansam.team.command.domain.aggregate.entity.TeamSchedule;
import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.common.response.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/team/{teamSeq}/schedule")
@Tag(name = "3-4-1. Team Schedule API", description = "팀 일정 API")
public class TeamScheduleController {

    private final TeamScheduleService teamScheduleService;

    @PostMapping
    @Operation(summary = "팀 일정 추가")
    public ApiResponse<String> createTeamSchedule(@RequestBody TeamScheduleDTO scheduleDTO) {
        boolean result = teamScheduleService.createTeamSchedule(scheduleDTO);
        return ResponseUtil.successResponse(result ? "팀 일정 추가 성공" : "팀 일정 추가 실패").getBody();
    }

    @PutMapping("/{scheduleSeq}")
    @Operation(summary = "팀 일정 수정")
    public ApiResponse<String> updateTeamSchedule(@PathVariable long scheduleSeq, @RequestBody TeamScheduleDTO scheduleDTO) {
        TeamSchedule teamSchedule = teamScheduleService.updateTeamSchedule(scheduleSeq, scheduleDTO);
        return ResponseUtil.successResponse("팀 일정 수정 성공").getBody();
    }

    @DeleteMapping("/{scheduleSeq}")
    @Operation(summary = "팀 일정 삭제")
    public ApiResponse<String> deleteTeamSchedule(@PathVariable long scheduleSeq) {
        teamScheduleService.deleteTeamSchedule(scheduleSeq);
        return ResponseUtil.successResponse("팀 일정 삭제 성공").getBody();
    }
}
