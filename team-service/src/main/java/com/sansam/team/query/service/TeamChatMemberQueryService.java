package com.sansam.team.query.service;


import com.sansam.team.query.dto.TeamChatMemberResponse;
import com.sansam.team.query.mapper.TeamChatMemberQueryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamChatMemberQueryService {
    private final TeamChatMemberQueryMapper teamChatMemberQueryMapper;

    public TeamChatMemberResponse selectTeamMember(Long teamMemberSeq) {
        TeamChatMemberResponse response = teamChatMemberQueryMapper.selectTeamMember(teamMemberSeq);
        return response;
    }
}
