package sansam.team.team.command.application.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sansam.team.team.command.application.dto.TeamReviewDTO;

@Slf4j
@Service
public class TeamReviewService {

    public boolean createTeamReview(TeamReviewDTO teamReviewDTO) {
        //TODO ayeong - 팀플이 끝난 후여야만 하고, 끝나는 날 ~ 2주까지만 등록 가능함.
        boolean result = false;

        return result;
    }

}
