package com.sansam.team.command.application.dto;


import com.sansam.team.common.aggregate.YnType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamChatCreateRequest {
    private String teamChatName;
    private String teamChatComment;
    private YnType teamChatActive = YnType.Y;
}
