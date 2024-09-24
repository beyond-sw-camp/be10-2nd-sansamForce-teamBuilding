package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.YnType;

@Entity
@Table(name = "tbl_project_member")
@Getter
@NoArgsConstructor
public class ProjectMember {

    @Id
    private Long projectMemberSeq;

    private YnType projectMemberDelYn = YnType.Y;

    private YnType projectMentorYn = YnType.Y;

    private Long userSeq;

    private Long projectSeq;

    public ProjectMember(YnType projectMemberDelYn, YnType projectMentorYn, Long userSeq, Long projectSeq) {
        this.projectMemberDelYn = projectMemberDelYn;
        this.projectMentorYn = projectMentorYn;
        this.userSeq = userSeq;
        this.projectSeq = projectSeq;
    }

    public static ProjectMember createEntity(YnType projectMemberDelYn, YnType projectMentorYn, Long userSeq, Long projectSeq) {
        return new ProjectMember(projectMemberDelYn, projectMentorYn, userSeq, projectSeq);
    }
}
