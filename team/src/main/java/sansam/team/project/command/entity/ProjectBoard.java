package sansam.team.project.command.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.embedded.Auditable;
import sansam.team.project.command.enums.BoardStatus;
import sansam.team.user.command.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_project_board")
@Getter
@NoArgsConstructor @AllArgsConstructor
public class ProjectBoard {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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
    private BoardStatus boardStatus = BoardStatus.RECRUITMENT; // 기본값 설정

    /* 생성일, 수정일, 삭제일 */
    @Embedded
    private Auditable auditable;

    @Column(name = "project_start_date", nullable = false)
    private LocalDateTime projectStartDate;

    @Column(name = "project_end_date")
    private LocalDateTime projectEndDate;

    // 유저와 프로젝트 보드 간 다대일 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq", nullable = false)
    private User user;
}

