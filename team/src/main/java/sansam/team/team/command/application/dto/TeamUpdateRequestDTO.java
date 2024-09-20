package sansam.team.team.command.application.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamUpdateRequestDTO {
    private long ruleSeq;
    private String teamName;
}
