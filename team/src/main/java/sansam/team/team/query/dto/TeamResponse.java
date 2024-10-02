package sansam.team.team.query.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamResponse {
    private String projectTitle;
    private Long teamSeq;
    private String teamName;
    private String regDate;
}