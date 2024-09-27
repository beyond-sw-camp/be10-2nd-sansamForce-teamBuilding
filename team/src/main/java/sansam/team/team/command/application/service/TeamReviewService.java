package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.common.util.DateTimeUtil;
import sansam.team.exception.CustomNotFoundException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.application.dto.TeamReviewDTO;
import sansam.team.team.command.domain.aggregate.TeamStatusType;
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
    public boolean createTeamReview(TeamReviewDTO teamReviewDTO) {
        boolean result = false;
        try {

            TeamMember teamMember = teamMemberService.getTeamMemberById(teamReviewDTO.getUserReviewSeq());
            Team team = teamService.getTeamById(teamMember.getTeamSeq());

            if(isReviewPeriod(team)) {
                teamReviewRepository.save(modelMapper.map(teamReviewDTO, TeamReview.class));
            }
            result = true;
        } catch (Exception e) {
            if(e.getMessage() != null) log.error("teamReview create Error : {}", e.getMessage());
            throw new CustomNotFoundException(ErrorCodeType.REVIEW_CREATE_ERROR);
        }

        return result;
    }

    public boolean isReviewPeriod(Team team) {
        return DateTimeUtil.isBeforeWeek(team.getEndDate(), 2) && team.getTeamStatus().equals(TeamStatusType.CLOSE);
    }

}
