package sansam.team.team.command.dto;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private long projectSeq;
    private long ruleSeq;
    private String teamName;
}
