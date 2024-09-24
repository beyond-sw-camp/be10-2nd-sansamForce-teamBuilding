package sansam.team.config.websocket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDTO {
    private ChatMessageType messageType;
    private Long teamSeq;   // 팀별 채팅방 ID
    private Long teamMemberSeq;  // 보낸 사람 팀원 Seq
    private String message;
}
