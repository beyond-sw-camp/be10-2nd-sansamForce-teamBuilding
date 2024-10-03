package com.sansam.team.query.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamFindByIdResponse {
    private Long teamSeq;
    private String teamName;
    private List<TeamMemberResponse> teamMemberList;
    private List<TeamScheduleResponse> teamScheduleList;
}
