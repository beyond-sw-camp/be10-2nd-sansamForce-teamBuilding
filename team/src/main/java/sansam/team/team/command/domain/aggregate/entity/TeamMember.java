package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

@Entity
@Table(name = "tbl_team_member")
@SequenceGenerator(
        name = "TEAM_MEMBER_SEQ_GENERATOR"
        , sequenceName = "TEAM_MEMBER_SEQ" //매핑할 데이터베이스 시퀀스 이름
        , allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamMember extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "TEAM_MEMBER_SEQ_GENERATOR")
    private long teamMemberSeq;
    private long teamSeq;
    private long userSeq;
}
