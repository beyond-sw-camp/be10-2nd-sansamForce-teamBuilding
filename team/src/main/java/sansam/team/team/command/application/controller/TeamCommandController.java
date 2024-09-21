package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.team.command.application.dto.TeamCreateRequestDTO;
import sansam.team.team.command.application.dto.TeamUpdateRequestDTO;
import sansam.team.team.command.application.service.TeamService;
import sansam.team.team.command.domain.aggregate.entity.Team;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
@Tag(name = "Team API", description = "팀 API")
public class TeamCommandController {

    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamCreateRequestDTO teamDTO) {
        Team team = teamService.createTeam(teamDTO);

        return ResponseEntity.ok(team);
    }

    @PutMapping("/{teamSeq}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long teamSeq, @RequestBody TeamUpdateRequestDTO teamDTO) {
        Team team = teamService.updateTeam(teamSeq, teamDTO);

        return ResponseEntity.ok(team);
    }

    @DeleteMapping("/{teamSeq}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long teamSeq) {
        teamService.deleteTeam(teamSeq);

        return ResponseEntity.noContent().build();
    }
}
