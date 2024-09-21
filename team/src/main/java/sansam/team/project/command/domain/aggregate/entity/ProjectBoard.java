package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.*;
import sansam.team.common.BaseTimeEntity;
import sansam.team.project.command.application.dto.board.ProjectBoardCreateDTO;
import sansam.team.project.command.application.dto.board.ProjectBoardUpdateDTO;
import sansam.team.project.command.domain.aggregate.BoardStatus;

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

    private ProjectBoard(String projectBoardTitle, String projectBoardContent, int projectBoardHeadCount, String projectBoardImgUrl, LocalDateTime projectBoardStartDate, LocalDateTime projectBoardEndDate, BoardStatus boardStatus, LocalDateTime projectStartDate, LocalDateTime projectEndDate, Long projectBoardAdminSeq) {
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
    }

    public void modifyProjectBoard(ProjectBoardUpdateDTO projectBoardUpdateDTO) {
        this.projectBoardTitle = projectBoardUpdateDTO.getProjectBoardTitle();
        this.projectBoardContent = projectBoardUpdateDTO.getProjectBoardContent();
        this.projectBoardHeadCount = projectBoardUpdateDTO.getProjectBoardHeadCount();
        this.projectBoardImgUrl = projectBoardUpdateDTO.getProjectBoardImgUrl();
        this.projectBoardStartDate = projectBoardUpdateDTO.getProjectBoardStartDate();
        this.projectBoardEndDate = projectBoardUpdateDTO.getProjectBoardEndDate();
        this.projectBoardStatus = projectBoardUpdateDTO.getBoardStatus();
        this.projectStartDate = projectBoardUpdateDTO.getProjectStartDate();
        this.projectEndDate = projectBoardUpdateDTO.getProjectEndDate();
    }
}
