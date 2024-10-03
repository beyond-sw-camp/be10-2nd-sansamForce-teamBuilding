package sansam.team.team.command.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sansam.team.team.command.application.dto.TeamReviewDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamReview;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeamReviewServiceTest {

    TeamReviewService teamReviewService;

    @Test
    public void testCreateTeamReview() {
        TeamReviewDTO teamReviewDTO = new TeamReviewDTO(1, 1, 2, 5.0, "코드를 잘쳐요");

        boolean result = teamReviewService.createTeamReview(teamReviewDTO);

        assertTrue(result);
    }

    @Test
    public void testUpdateTeamReview() {
        long reviewSeq = 1;
        TeamReviewDTO teamReviewDTO = new TeamReviewDTO(1, 1, 2, 5.0, "착해요");

        TeamReview updatedReview = teamReviewService.updateTeamReview(reviewSeq, teamReviewDTO);

        assertNotNull(updatedReview);
    }

    @Test
    public void testDeleteTeamReview() {
        long reviewSeq = 1;

        teamReviewService.deleteTeamReview(reviewSeq);
    }

}