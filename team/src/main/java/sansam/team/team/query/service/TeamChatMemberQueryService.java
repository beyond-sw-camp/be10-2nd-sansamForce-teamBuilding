package sansam.team.team.query.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sansam.team.team.query.dto.TeamChatMemberResponse;
import sansam.team.team.query.mapper.TeamChatMemberQueryMapper;

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
