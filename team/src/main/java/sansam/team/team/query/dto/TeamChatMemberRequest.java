package sansam.team.team.query.dto;

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
