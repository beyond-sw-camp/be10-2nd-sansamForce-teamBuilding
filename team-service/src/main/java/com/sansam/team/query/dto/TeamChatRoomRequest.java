package com.sansam.team.query.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamChatRoomRequest {
    Long teamChatSeq;
    Long userSeq;
}
