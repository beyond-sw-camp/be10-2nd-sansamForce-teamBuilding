package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;
import sansam.team.common.BaseTimeEntity;
import sansam.team.project.command.domain.aggregate.BoardStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_project_board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ProjectBoard extends BaseTimeEntity {

    @Id
    private Long projectBoardSeq;

    private String projectBoardTitle;

    private String projectBoardContent;

    private int projectBoardHeadCount;

    private String projectBoardImgUrl;

    private LocalDateTime projectBoardStartDate;

    private LocalDateTime projectBoardEndDate;

    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus = BoardStatus.RECRUITMENT;

    private LocalDateTime projectStartDate;

    private LocalDateTime projectEndDate;

    private Long projectBoardAdminSeq;

    @Builder
    public ProjectBoard(String projectBoardTitle, String projectBoardContent, int projectBoardHeadCount, String projectBoardImgUrl, LocalDateTime projectBoardStartDate, LocalDateTime projectBoardEndDate, BoardStatus boardStatus, LocalDateTime projectStartDate, LocalDateTime projectEndDate, Long projectBoardAdminSeq) {
        this.projectBoardTitle = projectBoardTitle;
        this.projectBoardContent = projectBoardContent;
        this.projectBoardHeadCount = projectBoardHeadCount;
        this.projectBoardImgUrl = projectBoardImgUrl;
        this.projectBoardStartDate = projectBoardStartDate;
        this.projectBoardEndDate = projectBoardEndDate;
        this.boardStatus = boardStatus;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectBoardAdminSeq = projectBoardAdminSeq;
    }
}
