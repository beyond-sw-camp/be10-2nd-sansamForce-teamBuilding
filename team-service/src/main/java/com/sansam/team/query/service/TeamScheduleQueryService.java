package com.sansam.team.query.service;

import com.sansam.team.query.dto.TeamScheduleQueryDTO;
import com.sansam.team.query.mapper.TeamScheduleQueryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamScheduleQueryService {

    private final TeamScheduleQueryMapper teamScheduleQueryMapper;

    public List<TeamScheduleQueryDTO> getTeamScheduleList(long teamSeq) {
        return teamScheduleQueryMapper.selectTeamScheduleList(teamSeq);
    }

}
