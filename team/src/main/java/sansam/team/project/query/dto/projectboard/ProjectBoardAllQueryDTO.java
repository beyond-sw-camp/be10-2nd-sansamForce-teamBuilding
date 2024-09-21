package sansam.team.project.query.dto.projectboard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBoardAllQueryDTO {

    /* (사용자, 관리자) 프로젝트 게시물 전체 조회 DTO */
    private Long projectBoardSeq;
    private String projectBoardTitle;
    private String projectBoardContent;
    private int projectBoardHeadCount;
    private String projectBoardImgUrl;
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;
    private String projectBoardStatus;
}
