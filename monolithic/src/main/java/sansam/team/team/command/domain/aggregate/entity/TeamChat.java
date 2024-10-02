package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import sansam.team.common.aggregate.entity.BaseTimeEntity;
import sansam.team.common.aggregate.YnType;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_team_chat")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SQLDelete(sql = "UPDATE tbl_team_chat SET team_chat_active = 'N', del_date = NOW() WHERE team_chat_seq = ?")
public class TeamChat extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
