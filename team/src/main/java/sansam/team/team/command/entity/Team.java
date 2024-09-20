package sansam.team.team.command.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.BaseTimeEntity;

@Entity
@Table(name = "tbl_team")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "TEAM_SEQ_GENERATOR",
        sequenceName = "TEAM_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)
public class Team extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "TEAM_SEQ_GENERATOR")
    private long teamSeq;   // 팀 번호
    private long projectSeq;    // 프로젝트 번호
    private long ruleSeq;   // 팀 빌딩 규칙 번호
    private String teamName;    // 팀명

    public void modifyTeamName(String teamName) {
        this.teamName = teamName;
    }   // 팀명 수정

    public void modifyTeam(long ruleSeq, String teamName) {
        this.ruleSeq = ruleSeq;
        this.teamName = teamName;
    }
}
