package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;
import sansam.team.team.command.domain.aggregate.TeamStatusType;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_team")
@Getter
@NoArgsConstructor
public class Team extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamSeq;   // 팀 번호
    private long projectSeq;    // 프로젝트 번호
    private long ruleSeq;   // 팀 빌딩 규칙 번호
    private String teamName;    // 팀명
    @Enumerated(EnumType.STRING)
    private TeamStatusType teamStatus;
    private LocalDateTime endDate;

    private Team(long projectSeq, long ruleSeq, String teamName) {
        this.projectSeq = projectSeq;
        this.ruleSeq = ruleSeq;
        this.teamName = teamName;
    }

    public static Team create(long projectSeq, long ruleSeq, String teamName) {
        return new Team(projectSeq, ruleSeq, teamName);
    }

    // @Builder
    // public Team(long projectSeq, long ruleSeq, String teamName) {
    //     this.projectSeq = projectSeq;
    //     this.ruleSeq = ruleSeq;
    //     this.teamName = teamName;
    // }

    public void modifyTeam(long ruleSeq, String teamName) {
        this.ruleSeq = ruleSeq;
        this.teamName = teamName;
    }
}
