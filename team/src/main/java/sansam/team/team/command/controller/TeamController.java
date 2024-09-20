package sansam.team.team.command.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.team.command.dto.TeamDTO;
import sansam.team.team.command.entity.Team;
import sansam.team.team.command.service.TeamService;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
@Tag(name = "Team API", description = "팀 API")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO) {
        Team team = teamService.createTeam(teamDTO);

        return ResponseEntity.ok(team);
    }

    @PutMapping("/{teamSeq}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long teamSeq, @RequestBody TeamDTO teamDTO) {
        Team team = teamService.updateTeam(teamSeq, teamDTO);

        return ResponseEntity.ok(team);
    }
}
