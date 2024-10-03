package sansam.team.team.command.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sansam.team.team.command.application.dto.TeamUpdateRequest;
import sansam.team.team.command.domain.aggregate.entity.Team;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TeamServiceTest {

    private TeamService teamService;

    private Team team;

    @Test
    public void testUpdateTeamTest() {
        long teamSeq = 1;
        TeamUpdateRequest request = new TeamUpdateRequest();
        request.setTeamName("테스트팀");
        request.setRuleSeq(100);

        Team updatedTeam = teamService.updateTeam(teamSeq, request);

        assertEquals(request.getTeamName(), updatedTeam.getTeamName());
    }

    @Test
    public void testDeleteTeamTest() {
        long teamSeq = 1;

        teamService.deleteTeam(teamSeq);
    }

    @Test
    public void testGetTeamByIdTest() {
        long teamSeq = 1;

        Team foundTeam = teamService.getTeamById(teamSeq);

        assertNotNull(foundTeam);
    }


}