package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.YnType;
import sansam.team.common.aggregate.entity.BaseTimeEntity;
import sansam.team.project.command.application.dto.project.ProjectMemberUpdateDTO;

@Entity
@Table(name = "tbl_project_member")
@Getter
@NoArgsConstructor
public class ProjectMember extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectMemberSeq;

    @Enumerated(EnumType.STRING)
    private YnType projectMemberDelYn = YnType.N;

    @Enumerated(EnumType.STRING)
    private YnType projectMentorYn = YnType.N;

    private Long userSeq;

    private Long projectSeq;

    public ProjectMember(Long userSeq, Long projectSeq) {
        this.userSeq = userSeq;
        this.projectSeq = projectSeq;
    }

    public static ProjectMember createEntity(Long userSeq, Long projectSeq) {
        return new ProjectMember(userSeq, projectSeq);
    }

    public void modifyProjectMember(ProjectMemberUpdateDTO updateDTO) {
        if (updateDTO.getProjectMemberDelYn() != null) {
            this.projectMemberDelYn = updateDTO.getProjectMemberDelYn();
        }
        if (updateDTO.getProjectMentorYn() != null) {
            this.projectMentorYn = updateDTO.getProjectMentorYn();
        }
    }
}
