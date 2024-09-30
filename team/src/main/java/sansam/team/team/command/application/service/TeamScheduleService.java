package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.exception.CustomNotFoundException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.application.dto.TeamScheduleDTO;
import sansam.team.team.command.domain.aggregate.TeamStatusType;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.aggregate.entity.TeamSchedule;
import sansam.team.team.command.domain.repository.TeamScheduleRepository;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamScheduleService {

    private final TeamService teamService;

    private final TeamScheduleRepository teamScheduleRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public boolean createTeamSchedule(TeamScheduleDTO scheduleDTO) {
        try {
            if(isSchedulePeriod(scheduleDTO)) {
                teamScheduleRepository.save(modelMapper.map(scheduleDTO, TeamSchedule.class));
                return true;
            }

        } catch (Exception e) {
            if(((CustomNotFoundException) e).getErrorCode() != null) {
                log.error("createTeamSchedule Error : {}", ((CustomNotFoundException) e).getErrorCode().getMessage());
                throw new CustomNotFoundException(((CustomNotFoundException) e).getErrorCode());
            } else {
                throw new RuntimeException("팀 일정 생성 중 오류가 발생하였습니다.");
            }
        }

        return false;
    }

    @Transactional
    public TeamSchedule updateTeamSchedule(long scheduleSeq, TeamScheduleDTO scheduleDTO) {
        try {
            TeamSchedule teamSchedule = teamScheduleRepository.findById(scheduleSeq)
                    .orElseThrow(() -> new CustomNotFoundException(ErrorCodeType.SCHEDULE_NOT_FOUND));

            if(isSchedulePeriod(modelMapper.map(teamSchedule, TeamScheduleDTO.class))) {
                teamSchedule.updateSchedule(scheduleDTO.getScheduleContent(), scheduleDTO.getScheduleStartDate(), scheduleDTO.getScheduleEndDate());
                teamScheduleRepository.save(teamSchedule);
            }

            return teamSchedule;

        } catch (Exception e) {
            if(((CustomNotFoundException) e).getErrorCode() != null) {
                log.error("updateTeamSchedule Error : {}", ((CustomNotFoundException) e).getErrorCode().getMessage());
                throw new CustomNotFoundException(((CustomNotFoundException) e).getErrorCode());
            } else {
                throw new RuntimeException("팀 일정 수정 중 오류가 발생하였습니다.");
            }
        }
    }

    /* 팀 일정 입력 가능 조건 체크 */
    public boolean isSchedulePeriod(TeamScheduleDTO scheduleDTO) {
        Team team = teamService.getTeamById(scheduleDTO.getTeamSeq());

        if (TeamStatusType.CLOSE.equals(team.getTeamStatus())) {
            throw new CustomNotFoundException(ErrorCodeType.TEAM_STATUS_ERROR);
        }

        if(team.getEndDate()!= null && team.getEndDate().isAfter(LocalDateTime.now())) {
            throw new CustomNotFoundException(ErrorCodeType.TEAM_END_ERROR);
        }

        return true;
    }

    @Transactional
    public void deleteTeamSchedule(long scheduleSeq) {
        try {
            teamScheduleRepository.deleteById(scheduleSeq);

        } catch (Exception e) {
            throw new CustomNotFoundException(ErrorCodeType.SCHEDULE_DELETE_ERROR);
        }
    }

}
