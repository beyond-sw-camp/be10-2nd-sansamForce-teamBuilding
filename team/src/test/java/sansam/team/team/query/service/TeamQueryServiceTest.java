package sansam.team.team.query.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sansam.team.team.query.dto.TeamFindByIdResponse;
import sansam.team.team.query.dto.TeamResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TeamQueryServiceTest {

    TeamQueryService teamService;

    @Test
    public void testSelectTeamList() {
        TeamResponse result = teamService.selectTeamList();

        assertNotNull(result);
    }

    @Test
    public void testSelectTeamById() {
        long teamSeq = 1;
        TeamFindByIdResponse result = teamService.selectTeamById(teamSeq);

        assertNotNull(result);
    }

}