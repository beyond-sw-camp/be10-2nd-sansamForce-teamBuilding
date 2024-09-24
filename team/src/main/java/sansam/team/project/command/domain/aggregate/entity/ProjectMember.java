package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.YnType;

@Entity
@Table(name = "tbl_project_member")
@Getter
@NoArgsConstructor
public class ProjectMember {

    @Id
    private int projectMemberSeq;

    private YnType projectMemberDelYn = YnType.Y;

    private YnType projectMentorYn = YnType.Y;

    private Long userSeq;

    private Long projectSeq;

}
