package com.sansam.team.query.dto;


import com.sansam.team.common.websocket.dto.TeamChatMemberDTO;
import com.sansam.team.common.websocket.dto.TeamChatMessageDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamChatRoomResponse {
    private long teamChatSeq;
    private long teamSeq;
    private String teamChatName;
    private String teamChatComment;
    private long teamMemberSeq;
    private String userNickName;

    private List<TeamChatMessageDTO> teamChatMessageList;
    private List<TeamChatMemberDTO> teamChatMemberList;

    private TeamChatMemberDTO teamChatMember;
}
