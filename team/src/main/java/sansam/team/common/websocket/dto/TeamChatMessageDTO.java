package sansam.team.common.websocket.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TeamChatMessageDTO {

    private Long teamChatMessageSeq;
    private TeamChatMessageType messageType; // 입장 혹은 메시지
    private Long teamChatSeq;   // 팀별 채팅방 ID
    private Long teamMemberSeq;  // 보낸 사람 팀원 Seq
    private String message;

    private LocalDateTime regDate = LocalDateTime.now();
}
