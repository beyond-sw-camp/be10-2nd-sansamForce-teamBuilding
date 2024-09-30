package sansam.team.team.command.application.dto;

import lombok.*;
import sansam.team.common.aggregate.YnType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeamChatMessageCreateRequest {
    private Long teamChatSeq;   // 팀별 채팅방 ID
    private Long teamMemberSeq;  // 보낸 사람 팀원 Seq
    private String message;
}
