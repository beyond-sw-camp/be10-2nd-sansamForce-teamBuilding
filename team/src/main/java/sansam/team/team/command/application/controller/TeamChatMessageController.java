package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.team.command.application.dto.TeamChatMessageCreateRequest;
import sansam.team.team.command.application.service.TeamChatMessageService;

@RestController
@RequestMapping("/api/v1/team/chat/message")
@RequiredArgsConstructor
@Tag(name = "Team Chatting Message API", description = "팀 채팅방 메시지 전송")
public class TeamChatMessageController {

    private final TeamChatMessageService teamChatMessageService;

    @PostMapping
    @Operation(summary = "채팅 메시지 전송")
    public ResponseEntity<Void> createTeamChatMessage(@RequestBody TeamChatMessageCreateRequest request) {
        teamChatMessageService.createTeamChatMessage(request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{teamChatMessageSeq}")
    @Operation(summary = "채팅 메시지 삭제")
    public ResponseEntity<Void> deleteTeamChatMessage(@PathVariable Long teamChatMessageSeq) {
        teamChatMessageService.deleteTeamChatMessage(teamChatMessageSeq);
        return ResponseEntity.noContent().build();
    }
}
