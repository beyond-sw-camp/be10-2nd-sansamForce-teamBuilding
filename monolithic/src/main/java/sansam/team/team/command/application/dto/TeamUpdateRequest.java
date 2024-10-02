package sansam.team.team.command.application.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamUpdateRequest {
    private long ruleSeq;
    private String teamName;
}
