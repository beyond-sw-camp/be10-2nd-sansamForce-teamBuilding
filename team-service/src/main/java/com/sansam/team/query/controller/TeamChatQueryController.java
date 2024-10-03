package com.sansam.team.query.controller;


import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.query.dto.TeamChatResponse;
import com.sansam.team.query.dto.TeamChatRoomResponse;
import com.sansam.team.query.service.TeamChatQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@RequiredArgsConstructor
@Tag(name = "3-5. Team Chat API", description = "팀 채팅방 API")
public class TeamChatQueryController {

    private final TeamChatQueryService teamChatQueryService;

    @GetMapping("/{teamSeq}/chat")
    @Operation(summary = "팀 채팅방 리스트 조회")
    public ApiResponse<List<TeamChatResponse>> selectChatRoomList() {
        List<TeamChatResponse> chatRooms = teamChatQueryService.selectChatRoomList();
        return ApiResponse.ofSuccess("Chat room list retrieved successfully", chatRooms);
    }

    @GetMapping("/{teamSeq}/chat/{teamChatSeq}")
    @Operation(summary = "팀 채팅방 조회(입장)")
    public ApiResponse<TeamChatRoomResponse> enterChatRoom(@PathVariable Long teamChatSeq) {
        TeamChatRoomResponse chatRoom = teamChatQueryService.selectChatRoom(teamChatSeq);
        return ApiResponse.ofSuccess("Entered chat room successfully", chatRoom);
    }
}
