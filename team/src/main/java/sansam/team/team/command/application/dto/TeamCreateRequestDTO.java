package sansam.team.team.command.application.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamCreateRequestDTO {
    private long projectSeq;
    private long ruleSeq;
    private String teamName;
}
