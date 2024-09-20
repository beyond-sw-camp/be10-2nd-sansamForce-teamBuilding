package sansam.team.team.command.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.team.command.dto.TeamDTO;
import sansam.team.team.command.entity.Team;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final ModelMapper modelMapper;
    private final TeamRepository teamRepository;

    @Transactional
    public Team createTeam(TeamDTO teamDTO) {

        Team team = modelMapper.map(teamDTO, Team.class);
        log.info("regDate : {}", team.getRegDate());

        try {
            teamRepository.save(team);
        } catch (Exception e) {
            log.error("TeamService createTeam Exception : {}", e);
        }

        return team;
    }

    @Transactional
    public Team updateTeam(long teamSeq, TeamDTO teamDTO) {
        Team team = teamRepository.findById(teamSeq).orElseThrow();
        team.modifyTeamName(teamDTO.getTeamName());

        log.info("modDate : {}", team.getModDate());

        return team;
    }
}
