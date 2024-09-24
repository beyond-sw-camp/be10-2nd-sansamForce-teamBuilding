package sansam.team.team.query.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sansam.team.common.jwt.SecurityUtil;
import sansam.team.team.query.dto.TeamChatDTO;
import sansam.team.team.query.dto.TeamChatQueryDTO;
import sansam.team.team.query.mapper.TeamChatQueryMapper;
import sansam.team.user.command.domain.aggregate.entity.User;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamChatQueryService {
    private final TeamChatQueryMapper teamChatQueryMapper;

    public List<TeamChatDTO> selectChatRoomList() {
        User user = SecurityUtil.getAuthenticatedUser();
        return teamChatQueryMapper.selectChatRoomList(new TeamChatQueryDTO(user.getUserSeq(), user.getUserAuth()));
    }

    public TeamChatDTO selectChatRoom(Long teamChatSeq) {
        return teamChatQueryMapper.selectChatRoom(teamChatSeq);
    }
}
