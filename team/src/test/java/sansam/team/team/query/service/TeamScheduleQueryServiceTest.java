package sansam.team.team.query.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sansam.team.team.query.dto.TeamScheduleQueryDTO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TeamScheduleQueryServiceTest {

    @Autowired
    private TeamScheduleQueryService teamScheduleQueryService;

    @Test
    public void testGetTeamScheduleList_Success() {
        // given
        long teamSeq = 1;

        // when
        List<TeamScheduleQueryDTO> result = teamScheduleQueryService.getTeamScheduleList(teamSeq);

        // then
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testGetTeamScheduleList_EmptyResult() {
        // given
        long teamSeq = 999;

        // when
        List<TeamScheduleQueryDTO> result = teamScheduleQueryService.getTeamScheduleList(teamSeq);

        // then
        assertNotNull(result);
        assertTrue(result.isEmpty());

    }
}