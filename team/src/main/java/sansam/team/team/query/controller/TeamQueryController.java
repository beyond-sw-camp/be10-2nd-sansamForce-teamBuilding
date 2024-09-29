package sansam.team.team.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.common.response.ApiResponse;
import sansam.team.team.query.dto.TeamScheduleQueryDTO;
import sansam.team.team.query.service.TeamQueryService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/query/team")
@RequiredArgsConstructor
@Tag(name = "Team API", description = "팀 API")
public class TeamQueryController {

    private final TeamQueryService teamQueryService;

    @GetMapping(value = {"/schedule/{teamSeq}"})
    @Operation(summary = "팀 일정 조회", description = "팀 일정 API")
    public ApiResponse<List<TeamScheduleQueryDTO>> loginProcess(@PathVariable long teamSeq) {
        List<TeamScheduleQueryDTO> teamScheduleList = teamQueryService.getTeamScheduleList(teamSeq);

        return ApiResponse.ofSuccess(teamScheduleList);
    }

}
