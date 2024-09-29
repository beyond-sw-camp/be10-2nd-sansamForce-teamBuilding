package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

@Entity
@Getter
@Table(name = "tbl_team_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamMember extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamMemberSeq;

    private long teamSeq;

    private long userSeq;

}
