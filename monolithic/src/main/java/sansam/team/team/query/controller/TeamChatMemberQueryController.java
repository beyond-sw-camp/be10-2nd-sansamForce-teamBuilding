package sansam.team.team.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.team.query.dto.TeamChatMemberResponse;
import sansam.team.team.query.service.TeamChatMemberQueryService;

@RestController
@RequestMapping("/api/v1/team/chat/member")
@RequiredArgsConstructor
@Tag(name = "3-7. Team Chatting Query API", description = "팀 채팅 멤버 조회 API")
public class TeamChatMemberQueryController {

    private final TeamChatMemberQueryService teamChatMemberQueryService;

    @GetMapping("/{teamMemberSeq}")
    @Operation(summary = "채팅방 팀원 정보 조회")
    public TeamChatMemberResponse selectTeamMember(@PathVariable Long teamMemberSeq) {

        return teamChatMemberQueryService.selectTeamMember(teamMemberSeq);
    }
}
