package sansam.team.team.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamScheduleResponse {
    private Long teamScheduleSeq;
    private String teamScheduleContent;
    private String teamScheduleStartDate;
    private String teamScheduleEndDate;
}
