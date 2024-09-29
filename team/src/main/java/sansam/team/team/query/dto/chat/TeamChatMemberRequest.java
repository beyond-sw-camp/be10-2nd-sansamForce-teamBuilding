package sansam.team.team.query.dto.chat;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamChatMemberRequest {
    Long teamMemberSeq;
    Long teamChatSeq;
    Long userSeq;
}
