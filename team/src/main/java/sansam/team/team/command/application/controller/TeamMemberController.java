package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.team.command.application.service.TeamMemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/team/member")
@Tag(name = "Team Chatting API", description = "팀 채팅방 API")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    @DeleteMapping("/{teamMemberSeq}")
    @Operation(summary = "팀 멤버 팀 탈퇴(채팅방 나가기)")
    public ResponseEntity<Void> deleteTeamMember(@PathVariable Long teamMemberSeq) {
        teamMemberService.deleteTeamMember(teamMemberSeq);

        return ResponseEntity.noContent().build();
    }
}
