package sansam.team.team.command.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamChatUpdateRequestDTO {
    private String teamChatName;
    private String teamChatComment;
}
