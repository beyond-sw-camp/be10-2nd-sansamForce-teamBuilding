package com.sansam.team.query.controller;


import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.query.dto.TeamChatMemberResponse;
import com.sansam.team.query.service.TeamChatMemberQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/team/chat/member")
@RequiredArgsConstructor
@Tag(name = "3-7. Team Chatting Query API", description = "팀 채팅 멤버 조회 API")
public class TeamChatMemberQueryController {

    private final TeamChatMemberQueryService teamChatMemberQueryService;

    @GetMapping("/{teamMemberSeq}")
    @Operation(summary = "채팅방 팀원 정보 조회")
    public ApiResponse<TeamChatMemberResponse> selectTeamMember(@PathVariable Long teamMemberSeq) {
        TeamChatMemberResponse teamChatMemberResponse = teamChatMemberQueryService.selectTeamMember(teamMemberSeq);
        return ApiResponse.ofSuccess("Team member information retrieved successfully", teamChatMemberResponse);
    }
}
