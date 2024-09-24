package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.team.command.application.dto.TeamChatCreateRequestDTO;
import sansam.team.team.command.application.dto.TeamChatUpdateRequestDTO;
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
    public ResponseEntity<TeamChat> createTeamChat(@PathVariable Long teamSeq, @RequestBody TeamChatCreateRequestDTO teamChatDTO) {
        TeamChat teamChat = teamChatService.createTeamChat(teamSeq, teamChatDTO);

        return ResponseEntity.ok(teamChat);
    }

    @PutMapping("/{teamChatSeq}")
    @Operation(summary = "팀 채팅방 정보 수정")
    public ResponseEntity<TeamChat> updateTeamChat(@PathVariable Long teamChatSeq, @RequestBody TeamChatUpdateRequestDTO teamChatDTO) {
        TeamChat teamChat = teamChatService.updateTeamChat(teamChatSeq, teamChatDTO);

        return ResponseEntity.ok(teamChat);
    }

    @DeleteMapping("/{teamChatSeq}")
    @Operation(summary = "팀 채팅방 논리 삭제")
    public ResponseEntity<Void> deleteTeamChat(@PathVariable Long teamChatSeq) {
        teamChatService.deleteTeamChat(teamChatSeq);

        return ResponseEntity.noContent().build();
    }
}
