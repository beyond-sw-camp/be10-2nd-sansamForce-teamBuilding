package com.sansam.team.command.application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamChatUpdateRequest {
    private String teamChatName;
    private String teamChatComment;
}
