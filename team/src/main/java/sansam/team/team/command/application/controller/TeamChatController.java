package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.team.command.application.dto.TeamChatCreateRequest;
import sansam.team.team.command.application.dto.TeamChatUpdateRequest;
import sansam.team.team.command.application.service.TeamChatService;
import sansam.team.team.command.domain.aggregate.entity.TeamChat;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/team/chat")
@Tag(name = "Team Chatting API", description = "팀 채팅방 API")
public class TeamChatController {

    private final TeamChatService teamChatService;

    @PostMapping("/{teamSeq}")
    @Operation(summary = "팀 채팅방 추가")
    public ResponseEntity<TeamChat> createTeamChat(@PathVariable Long teamSeq, @RequestBody TeamChatCreateRequest request) {
        TeamChat teamChat = teamChatService.createTeamChat(teamSeq, request);

        return ResponseEntity.ok(teamChat);
    }

    @PutMapping("/{teamChatSeq}")
    @Operation(summary = "팀 채팅방 정보 수정")
    public ResponseEntity<TeamChat> updateTeamChat(@PathVariable Long teamChatSeq, @RequestBody TeamChatUpdateRequest request) {
        TeamChat teamChat = teamChatService.updateTeamChat(teamChatSeq, request);

        return ResponseEntity.ok(teamChat);
    }

    @DeleteMapping("/{teamChatSeq}")
    @Operation(summary = "팀 채팅방 나가기")
    public ResponseEntity<Void> leaveTeamChat(@PathVariable Long teamChatSeq, @RequestParam Long teamMemberSeq) {
        teamChatService.leaveTeamChat(teamChatSeq, teamMemberSeq);

        return ResponseEntity.noContent().build();
    }
}
