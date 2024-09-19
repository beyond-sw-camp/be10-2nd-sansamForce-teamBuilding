package sansam.team.project.command.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.embedded.Auditable;
import sansam.team.common.embedded.AuditableEntity;
import sansam.team.common.embedded.BaseEntity;
import sansam.team.project.command.enums.BoardStatus;
import sansam.team.user.command.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_project_board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(BaseEntity.class)
public class ProjectBoard implements AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_board_seq")
    private Long projectBoardSeq;

    @Column(name = "project_board_title", nullable = false)
    private String projectBoardTitle;

    @Column(name = "project_board_content", nullable = false)
    private String projectBoardContent;

    @Column(name = "project_board_head_count", nullable = false)
    private int projectBoardHeadCount;

    @Column(name = "project_board_img_url")
    private String projectBoardImgUrl;

    @Column(name = "project_board_start_date", nullable = false)
    private LocalDateTime projectBoardStartDate;

    @Column(name = "project_board_end_date")
    private LocalDateTime projectBoardEndDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_board_status", nullable = false)
    private BoardStatus boardStatus = BoardStatus.RECRUITMENT;

    // Auditable 필드를 초기화
    @Embedded
    private Auditable auditable = new Auditable(); // 여기에서 기본값으로 초기화

    @Column(name = "project_start_date", nullable = false)
    private LocalDateTime projectStartDate;

    @Column(name = "project_end_date")
    private LocalDateTime projectEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    @JsonIgnore // 순환 참조 방지: 직렬화에서 무시
    private User user;

    @OneToMany(mappedBy = "projectBoard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectApplyMember> projectApplyMembers = new ArrayList<>();

    @Override
    public Auditable getAuditable() {
        return auditable;
    }

    @Override
    public void setAuditable(Auditable auditable) {
        this.auditable = auditable;
    }


}
