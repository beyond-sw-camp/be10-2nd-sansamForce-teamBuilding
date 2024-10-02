package sansam.team.team.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.team.query.dto.TeamFindByIdResponse;
import sansam.team.team.query.dto.TeamResponse;
import sansam.team.team.query.service.TeamQueryService;

@Slf4j
@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
@Tag(name = "3-3. Team API", description = "팀 API")
public class TeamQueryController {

    private final TeamQueryService teamQueryService;

    @GetMapping
    @Operation(summary = "팀 리스트 조회")
    public TeamResponse selectTeamList() {
        return teamQueryService.selectTeamList();

    }

    @GetMapping("/{teamSeq}")
    @Operation(summary = "팀 조회")
    public TeamFindByIdResponse selectTeamById(@PathVariable Long teamSeq) {
        return teamQueryService.selectTeamById(teamSeq);

    }
}
