package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.application.dto.TeamMemberScheduleDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamMemberSchedule;
import sansam.team.team.command.domain.repository.TeamMemberScheduleRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamMemberScheduleService {

    private TeamMemberScheduleRepository teamMemberScheduleRepository;

    private ModelMapper modelMapper;

    @Transactional
    public boolean createScheduleByMember(TeamMemberScheduleDTO memberScheduleDTO) {
        boolean result = false;

        try {
            if(isScheduleByMember(memberScheduleDTO)) {
                teamMemberScheduleRepository.save(modelMapper.map(memberScheduleDTO, TeamMemberSchedule.class));
                result = true;
            }

        } catch (Exception e) {
            if(((CustomException) e).getErrorCode() != null) {
                log.error("teamMemberSchedule create Error : {}", ((CustomException) e).getErrorCode().getMessage());
                throw new CustomException(((CustomException) e).getErrorCode());
            } else {
                throw new CustomException(ErrorCodeType.MEMBER_SCHEDULE_CREATE_ERROR);
            }
        }

        return result;
    }

    /*@Transactional
    public TeamMemberSchedule updateScheduleByMember(long memberScheduleSeq, TeamMemberScheduleDTO memberScheduleDTO) {
        try {
            TeamMemberSchedule teamMemberSchedule = teamMemberScheduleRepository.findById(memberScheduleSeq)
                    .orElseThrow(() -> new CustomException(ErrorCodeType.));

            if(isScheduleByMember(modelMapper.map(teamMemberSchedule, TeamMemberScheduleDTO.class))) {
                teamMemberSchedule.updateReview(memberScheduleDTO.getReceiveMemberSeq(), memberScheduleDTO.getReviewStar(), memberScheduleDTO.getReviewContent());
                teamMemberScheduleRepository.save(teamMemberSchedule);
            }

            return teamMemberSchedule;

        } catch (Exception e) {
            if(((CustomException) e).getErrorCode() != null) {
                log.error("teamMemberSchedule update Error : {}", ((CustomException) e).getErrorCode().getMessage());
                throw new CustomException(((CustomException) e).getErrorCode());
            } else {
                throw new CustomException(ErrorCodeType.);
            }
        }
    }*/

    /* 팀원별 일정 진행상황 입력 조건체크 */
    public boolean isScheduleByMember(TeamMemberScheduleDTO memberScheduleDTO) {
        // TODO 아영 - feedback은 강사 권한만 가능
        boolean result = false;

        // 팀 상태와 END_DATE 체크

        // 팀 일정 seq 체크, 일정 시작일 종료일 체크 (해당 일정의 기간을 확인해주세요.)

        return result;
    }

    @Transactional
    public void deleteScheduleByMember(long memberScheduleSeq) {
        teamMemberScheduleRepository.deleteById(memberScheduleSeq);
    }

}
