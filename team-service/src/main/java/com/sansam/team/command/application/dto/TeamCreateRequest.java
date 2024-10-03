package com.sansam.team.command.application.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamCreateRequest {
    private long projectSeq;
    private long ruleSeq;
    private String teamName;
}
