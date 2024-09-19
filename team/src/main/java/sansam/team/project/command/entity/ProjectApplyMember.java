package sansam.team.project.command.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.embedded.Auditable;
import sansam.team.common.embedded.AuditableEntity;
import sansam.team.common.embedded.BaseEntity;
import sansam.team.project.command.enums.ApplyStatus;
import sansam.team.user.command.entity.User;

@Entity
@Table(name = "tbl_project_apply_member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(BaseEntity.class)
public class ProjectApplyMember implements AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_apply_member_seq")
    private Long projectApplyMemberSeq;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_apply_member_status", nullable = false)
    private ApplyStatus projectApplyMemberStatus = ApplyStatus.APPLIED; // 지원 상태

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    @JsonIgnore
    private User user;  // User와 1:N 관계

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_board_seq", nullable = false)
    @JsonIgnore
    private ProjectBoard projectBoard;  // ProjectBoard와 1:N 관계

    @Embedded
    private Auditable auditable = new Auditable();

    @Override
    public Auditable getAuditable() {
        return auditable;
    }

    @Override
    public void setAuditable(Auditable auditable) {
        this.auditable = auditable;
    }
}
