package com.sansam.team.command.application.controller;


import com.sansam.team.command.application.dto.TeamChatMessageCreateRequest;
import com.sansam.team.command.application.service.TeamChatMessageService;
import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.common.response.ResponseUtil;
import com.sansam.team.exception.CustomException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/team/{teamSeq}/chat/message")
@RequiredArgsConstructor
@Tag(name = "3-6. Team Chatting Message API", description = "팀 채팅방 메시지 전송")
public class TeamChatMessageController {

    private final TeamChatMessageService teamChatMessageService;

    @PostMapping
    @Operation(summary = "채팅 메시지 전송")
    public ApiResponse<?> createTeamChatMessage(@RequestBody TeamChatMessageCreateRequest request) {
        try {
            teamChatMessageService.createTeamChatMessage(request);

            return ResponseUtil.successResponse("Team Chat Message insert success").getBody();
        } catch (CustomException e) {
            return ResponseUtil.exceptionResponse(e, String.valueOf(e.getErrorCode())).getBody();
        } catch (Exception e) {
            return ResponseUtil.exceptionResponse(e, "TEAM_CHAT_MESSAGE_INSERT_ERROR").getBody();
        }
    }

    @DeleteMapping("/{teamChatMessageSeq}")
    @Operation(summary = "채팅 메시지 삭제")
    public ApiResponse<?> deleteTeamChatMessage(@PathVariable Long teamSeq, @PathVariable Long teamChatMessageSeq) {
        try {
            teamChatMessageService.deleteTeamChatMessage(teamSeq, teamChatMessageSeq);

            return ResponseUtil.successResponse("Team Chat Message delete success").getBody();
        } catch (CustomException e) {
            return ResponseUtil.exceptionResponse(e, String.valueOf(e.getErrorCode())).getBody();
        } catch (Exception e) {
            return ResponseUtil.exceptionResponse(e, "TEAM_CHAT_MESSAGE_DELETE_ERROR").getBody();
        }
    }
}
