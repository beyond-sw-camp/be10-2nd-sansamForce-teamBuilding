package com.sansam.team.command.application.controller;


import com.sansam.team.command.application.service.TeamMemberService;
import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.common.response.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/team/{teamSeq}/member")
@Tag(name = "3-5. Team Chat API", description = "팀 채팅방 API")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    @DeleteMapping("/{teamMemberSeq}")
    @Operation(summary = "팀 멤버 팀 탈퇴(채팅방 나가기)")
    public ApiResponse<?> deleteTeamMember(@PathVariable Long teamMemberSeq) {
        teamMemberService.deleteTeamMember(teamMemberSeq);

        return ResponseUtil.successResponse("Team Member delete success").getBody();
    }
}
