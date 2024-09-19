package sansam.team.project.command.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.embedded.Auditable;
import sansam.team.common.embedded.AuditableEntity;
import sansam.team.common.embedded.BaseEntity;
import sansam.team.project.command.enums.ProjectStatus;
import sansam.team.user.command.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_project")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(BaseEntity.class)
public class Project implements AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_seq")
    private Long projectSeq;

    @Column(name = "project_title", nullable = false)
    private String projectTitle;

    @Column(name = "project_content", nullable = false)
    private String projectContent;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status", nullable = false)
    private ProjectStatus projectStatus = ProjectStatus.PROGRESS;

    @Column(name = "project_head_count", nullable = false)
    private int projectHeadCount;

    @Column(name = "project_img_url")
    private String projectImgUrl;

    @Column(name = "project_start_date")
    private LocalDateTime projectStartDate;

    @Column(name = "project_end_date")
    private LocalDateTime projectEndDate;

    @Embedded
    private Auditable auditable = new Auditable();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    @JsonIgnore
    private User user;

    @Override
    public Auditable getAuditable() {
        return auditable;
    }

    @Override
    public void setAuditable(Auditable auditable) {
        this.auditable = auditable;
    }
}
