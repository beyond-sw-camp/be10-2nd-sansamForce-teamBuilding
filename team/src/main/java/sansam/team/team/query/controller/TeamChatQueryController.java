package sansam.team.team.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sansam.team.team.query.dto.chat.TeamChatResponse;
import sansam.team.team.query.dto.chat.TeamChatRoomResponse;
import sansam.team.team.query.service.TeamChatQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team/chat")
@RequiredArgsConstructor
@Tag(name = "Team Chatting Query API", description = "팀 채팅방 조회 API")
public class TeamChatQueryController {

    private final TeamChatQueryService teamChatQueryService;

    @GetMapping
    @Operation(summary = "팀 채팅방 리스트 조회")
    public List<TeamChatResponse> selectChatRoomList() {
        return teamChatQueryService.selectChatRoomList();
    }

    @GetMapping("/{teamChatSeq}")
    @Operation(summary = "팀 채팅방 입장")
    public TeamChatRoomResponse enterChatRoom(@PathVariable Long teamChatSeq) {
        return teamChatQueryService.selectChatRoom(teamChatSeq);
    }
}
