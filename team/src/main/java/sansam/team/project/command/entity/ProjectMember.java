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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_member_seq")
    private int projectMemberSeq;

    @Column(name = "project_member_del_yn", nullable = false)
    private String projectMemberDelYn;

    @Column(name = "project_mentor_yn", nullable = false)
    private String projectMentorYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_seq", nullable = false)
    @JsonIgnore
    private Project project;

}
