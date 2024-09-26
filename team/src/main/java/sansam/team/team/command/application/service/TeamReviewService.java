package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.team.command.application.dto.TeamReviewDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamReview;
import sansam.team.team.command.domain.repository.TeamRepository;
import sansam.team.team.command.domain.repository.TeamReviewRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamReviewService {
    private final TeamReviewRepository teamReviewRepository;
    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public boolean createTeamReview(TeamReviewDTO teamReviewDTO) {
        boolean result = false;
        try {

            teamReviewRepository.save(modelMapper.map(teamReviewDTO, TeamReview.class));
            result = true;
        } catch (Exception e) {
            if(e.getMessage() != null) log.error("teamReview create Error : {}", e.getMessage());
        }

        return result;
    }

}
