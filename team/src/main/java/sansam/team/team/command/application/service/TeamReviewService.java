package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.application.dto.TeamReviewDTO;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.aggregate.entity.TeamMember;
import sansam.team.team.command.domain.aggregate.entity.TeamReview;
import sansam.team.team.command.domain.repository.TeamReviewRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamReviewService {
    private final TeamReviewRepository teamReviewRepository;
    private final TeamMemberService teamMemberService;
    private final TeamService teamService;
    private final ModelMapper modelMapper;

    @Transactional
    public boolean createTeamReview(TeamReviewDTO teamReviewDTO) throws CustomException {
        boolean result = false;
        try {

            TeamMember teamMember = teamMemberService.getTeamMemberById(teamReviewDTO.getUserReviewSeq());
            Team team = teamService.getTeamById(teamMember.getTeamSeq());

            // TODO 아영 - timeUtil로 팀시가 계산해서 status='CLOSE'이고, 평가 기간일때만 입력가능 코드 추가하기
            teamReviewRepository.save(modelMapper.map(teamReviewDTO, TeamReview.class));
            result = true;
        } catch (Exception e) {
            if(e.getMessage() != null) log.error("teamReview create Error : {}", e.getMessage());
            throw new CustomException(ErrorCodeType.COMMON_ERROR);
        }

        return result;
    }

}
