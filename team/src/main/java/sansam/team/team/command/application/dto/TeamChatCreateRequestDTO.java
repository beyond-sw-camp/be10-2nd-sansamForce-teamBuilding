package sansam.team.team.command.application.dto;

import lombok.*;
import sansam.team.common.YnType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamChatCreateRequestDTO {
    private long teamSeq;
    private String teamChatName;
    private String teamChatComment;
    private YnType teamChatActive;
}
