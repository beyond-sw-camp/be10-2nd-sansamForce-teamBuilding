package sansam.team.team.command.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.BaseTimeEntity;
import sansam.team.common.YesNo;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_team_chat")
@SequenceGenerator(
        name = "TEAM_CHAT_SEQ_GENERATOR",
        sequenceName = "TEAM_CHAT_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamChat extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "TEAM_CHAT_SEQ_GENERATOR")
    private long teamChatSeq;
    private long teamSeq;
    private String teamChatName;
    private String teamChatComment;
    private YesNo teamChatActive;

    private LocalDateTime delDate;
}
