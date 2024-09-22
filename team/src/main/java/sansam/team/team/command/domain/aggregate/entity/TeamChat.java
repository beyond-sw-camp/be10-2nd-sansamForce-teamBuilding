package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import sansam.team.common.BaseTimeEntity;
import sansam.team.common.YnType;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_team_chat")
@SequenceGenerator(
        name = "TEAM_CHAT_SEQ_GENERATOR"
        , sequenceName = "TEAM_CHAT_SEQ" //매핑할 데이터베이스 시퀀스 이름
        , allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE tbl_team_chat SET team_chat_active = 'N', del_date = NOW() WHERE team_chat_seq = ?")
public class TeamChat extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "TEAM_CHAT_SEQ_GENERATOR")
    private long teamChatSeq;
    private long teamSeq;
    private String teamChatName;
    private String teamChatComment;
    @Enumerated(value = EnumType.STRING)
    private YnType teamChatActive;

    private LocalDateTime delDate;

    @Builder
    protected TeamChat(long teamSeq, String teamChatName, String teamChatComment, YnType teamChatActive) {
        this.teamSeq = teamSeq;
        this.teamChatName = teamChatName;
        this.teamChatComment = teamChatComment;
        this.teamChatActive = teamChatActive;
    }

    public void modifyTeamChat(String teamChatName, String teamChatComment) {
        this.teamChatName = teamChatName;
        this.teamChatComment = teamChatComment;
    }
}
