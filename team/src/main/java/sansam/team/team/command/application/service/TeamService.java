package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.team.command.application.dto.TeamCreateRequest;
import sansam.team.team.command.application.dto.TeamUpdateRequest;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.repository.TeamRepository;
import sansam.team.team.command.mapper.TeamMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public Team createTeam(TeamCreateRequest request) {
        Team team = TeamMapper.toEntity(request);

        teamRepository.save(team);

        return team;
    }

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


}
