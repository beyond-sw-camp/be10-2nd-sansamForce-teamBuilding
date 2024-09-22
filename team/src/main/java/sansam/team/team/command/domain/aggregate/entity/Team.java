package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.BaseTimeEntity;

@Entity
@Table(name = "tbl_team")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "TEAM_SEQ_GENERATOR"
        , sequenceName = "team_seq" //매핑할 데이터베이스 시퀀스 이름
        , allocationSize = 1)
public class Team extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "TEAM_SEQ_GENERATOR")
    private long teamSeq;   // 팀 번호
    private long projectSeq;    // 프로젝트 번호
    private long ruleSeq;   // 팀 빌딩 규칙 번호
    private String teamName;    // 팀명

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
