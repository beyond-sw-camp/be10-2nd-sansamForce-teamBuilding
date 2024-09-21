package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.YesNo;

@Entity
@Table(name = "tbl_project_member")
@Getter
@NoArgsConstructor
public class ProjectMember {

    @Id
    private int projectMemberSeq;

    private YesNo projectMemberDelYn = YesNo.Y;

    private YesNo projectMentorYn = YesNo.Y;

    private Long userSeq;

    private Long projectSeq;

}
