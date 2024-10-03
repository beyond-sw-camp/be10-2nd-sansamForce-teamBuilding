package com.sansam.project.command.domain.aggregate.entity;

import com.sansam.project.command.application.dto.AdminProjectBoardUpdateDTO;
import com.sansam.project.command.domain.aggregate.BoardStatus;
import com.sansam.project.common.aggregate.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_project_board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ProjectBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectBoardSeq;

    private String projectBoardTitle;

    private String projectBoardContent;

    private int projectBoardHeadCount;

    private String projectBoardImgUrl;

    private LocalDateTime projectBoardStartDate;

    private LocalDateTime projectBoardEndDate;

    @Enumerated(EnumType.STRING)
    private BoardStatus projectBoardStatus = BoardStatus.RECRUITMENT;

    private LocalDateTime projectStartDate;

    private LocalDateTime projectEndDate;

    private Long projectBoardAdminSeq;

    private LocalDateTime delDate;

    /*private ProjectBoard(String projectBoardTitle, String projectBoardContent, int projectBoardHeadCount, String projectBoardImgUrl, LocalDateTime projectBoardStartDate, LocalDateTime projectBoardEndDate, BoardStatus boardStatus, LocalDateTime projectStartDate, LocalDateTime projectEndDate, Long projectBoardAdminSeq) {
        this.projectBoardTitle = projectBoardTitle;
        this.projectBoardContent = projectBoardContent;
        this.projectBoardHeadCount = projectBoardHeadCount;
        this.projectBoardImgUrl = projectBoardImgUrl;
        this.projectBoardStartDate = projectBoardStartDate;
        this.projectBoardEndDate = projectBoardEndDate;
        this.projectBoardStatus = boardStatus;
        this.projectStartDate = projectStartDate;
        this.projectEndDate = projectEndDate;
        this.projectBoardAdminSeq = projectBoardAdminSeq;
    }

    public static ProjectBoard createEntity(String projectBoardTitle, String projectBoardContent, int projectBoardHeadCount, String projectBoardImgUrl, LocalDateTime projectBoardStartDate, LocalDateTime projectBoardEndDate, BoardStatus boardStatus, LocalDateTime projectStartDate, LocalDateTime projectEndDate, Long projectBoardAdminSeq) {
        
        return new ProjectBoard(projectBoardTitle, projectBoardContent, projectBoardHeadCount, projectBoardImgUrl, projectBoardStartDate, projectBoardEndDate, boardStatus, projectStartDate, projectEndDate, projectBoardAdminSeq);
    } */

    public void modifyProjectBoard(AdminProjectBoardUpdateDTO adminProjectBoardUpdateDTO) {
        this.projectBoardTitle = adminProjectBoardUpdateDTO.getProjectBoardTitle();
        this.projectBoardContent = adminProjectBoardUpdateDTO.getProjectBoardContent();
        this.projectBoardHeadCount = adminProjectBoardUpdateDTO.getProjectBoardHeadCount();
        this.projectBoardImgUrl = adminProjectBoardUpdateDTO.getProjectBoardImgUrl();
        this.projectBoardStartDate = adminProjectBoardUpdateDTO.getProjectBoardStartDate();
        this.projectBoardEndDate = adminProjectBoardUpdateDTO.getProjectBoardEndDate();
        this.projectBoardStatus = adminProjectBoardUpdateDTO.getBoardStatus();
        this.projectStartDate = adminProjectBoardUpdateDTO.getProjectStartDate();
        this.projectEndDate = adminProjectBoardUpdateDTO.getProjectEndDate();
    }

    public void setProjectBoardAdminSeq(Long userSeq) {
        this.projectBoardAdminSeq = userSeq;
    }
}