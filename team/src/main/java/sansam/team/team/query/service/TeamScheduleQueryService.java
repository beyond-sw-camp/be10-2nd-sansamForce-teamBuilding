package sansam.team.team.query.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sansam.team.team.query.dto.TeamScheduleQueryDTO;
import sansam.team.team.query.mapper.TeamScheduleQueryMapper;

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
