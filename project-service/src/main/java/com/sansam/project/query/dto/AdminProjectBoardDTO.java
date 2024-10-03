package com.sansam.project.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminProjectBoardDTO {

    /* 관리자 전용 프로젝트 게시물 상세 조회 DTO */
    private Long projectBoardSeq;
    private Long projectBoardAdminSeq;
    private String projectBoardTitle;
    private String projectBoardContent;
    private int projectBoardHeadCount;
    private String projectBoardImgUrl;
    private LocalDateTime projectBoardStartDate;
    private LocalDateTime projectBoardEndDate;
    private String projectBoardStatus;
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;

    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private LocalDateTime delDate;


}