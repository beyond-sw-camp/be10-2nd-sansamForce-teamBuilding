package com.sansam.team.command.application.service;


import com.sansam.team.command.application.dto.TeamUpdateRequest;
import com.sansam.team.command.domain.aggregate.entity.Team;
import com.sansam.team.command.domain.repository.TeamRepository;
import com.sansam.team.command.domain.repository.TeamScheduleRepository;
import com.sansam.team.exception.CustomException;
import com.sansam.team.exception.ErrorCodeType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    private final TeamScheduleRepository teamScheduleRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public Team updateTeam(Long teamSeq, TeamUpdateRequest request) {
        Team team = teamRepository.findById(teamSeq).orElseThrow();

        team.modifyTeam(request.getRuleSeq(), request.getTeamName());

        return team;
    }

    @Transactional
    public void deleteTeam(Long teamSeq) {
        teamRepository.deleteById(teamSeq);
    }

    @Transactional
    public Team getTeamById(long teamSeq) throws CustomException {
        return teamRepository.findById(teamSeq)
                .orElseThrow(() -> new CustomException(ErrorCodeType.TEAM_NOT_FOUND));
    }

}
