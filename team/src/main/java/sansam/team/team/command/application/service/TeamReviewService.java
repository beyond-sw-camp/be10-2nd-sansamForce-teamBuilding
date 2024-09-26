package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.exception.CustomException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.application.dto.TeamReviewDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamReview;
import sansam.team.team.command.domain.repository.TeamReviewRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamReviewService {
    private final TeamReviewRepository teamReviewRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public boolean createTeamReview(TeamReviewDTO teamReviewDTO) throws CustomException {
        //TODO ayeong - 팀플이 끝난 후여야만 하고, 끝나는 날 ~ 2주까지만 등록 가능함.
        boolean result = false;
        try {
            teamReviewRepository.save(modelMapper.map(teamReviewDTO, TeamReview.class));
            result = true;
        } catch (Exception e) {
            if(e.getMessage() != null) log.error("teamReview create Error : {}", e.getMessage());
            throw new CustomException(ErrorCodeType.COMMON_ERROR);
        }

        return result;
    }

}
