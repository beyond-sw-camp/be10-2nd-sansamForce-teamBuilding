package com.sansam.team.query.controller;


import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.query.dto.TeamScheduleQueryDTO;
import com.sansam.team.query.service.TeamScheduleQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/team/{teamSeq}/schedule")
@RequiredArgsConstructor
@Tag(name = "3-4-1. Team Schedule API", description = "팀 일정 API")
public class TeamScheduleQueryController {

    private final TeamScheduleQueryService teamScheduleQueryService;

    @GetMapping
    @Operation(summary = "팀 일정 조회", description = "팀 일정 API")
    public ApiResponse<List<TeamScheduleQueryDTO>> getTeamScheduleList(@PathVariable long teamSeq) {
        List<TeamScheduleQueryDTO> scheduleList = teamScheduleQueryService.getTeamScheduleList(teamSeq);
        return ApiResponse.ofSuccess("Team schedule list retrieved successfully", scheduleList);
    }

}
