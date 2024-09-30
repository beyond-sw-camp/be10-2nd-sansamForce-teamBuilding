package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;

@Entity
@Getter
@Table(name = "tbl_team_member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamMember extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamMemberSeq;

    private long teamSeq;

    private long userSeq;

    public TeamMember(Long userSeq, Long teamSeq) {
        this.userSeq = userSeq;
        this.teamSeq = teamSeq;
    }

    public static TeamMember createEntity(Long userSeq, Long teamSeq) {
        return new TeamMember(userSeq, teamSeq);
    }

    public void modifyTeamMember(long teamSeq) {
        this.teamSeq = teamSeq;
    }

}
