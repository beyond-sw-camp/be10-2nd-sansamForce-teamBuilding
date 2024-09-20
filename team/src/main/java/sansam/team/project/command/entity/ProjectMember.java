package sansam.team.project.command.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.user.command.entity.User;

@Entity
@Table(name = "tbl_project_member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMember {

    @Id
    private int projectMemberSeq;

    private String projectMemberDelYn;

    private String projectMentorYn;

    private Long userSeq;

    private Long projectSeq;

}
