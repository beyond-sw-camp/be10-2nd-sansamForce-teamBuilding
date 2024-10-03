package com.sansam.team.query.service;


import com.sansam.team.query.dto.TeamFindByIdResponse;
import com.sansam.team.query.dto.TeamRequest;
import com.sansam.team.query.dto.TeamResponse;
import com.sansam.team.query.mapper.TeamQueryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamQueryService {

    private final TeamQueryMapper teamQueryMapper;

    public TeamResponse selectTeamList() {
        CustomUserDTO user = SecurityUtil.getAuthenticatedUser();
        return teamQueryMapper.selectTeamList(new TeamRequest(user.getUserSeq(), user.getUserAuth()));
    }

    public TeamFindByIdResponse selectTeamById(Long teamSeq) {
        return teamQueryMapper.selectTeamById(teamSeq);
    }

}
