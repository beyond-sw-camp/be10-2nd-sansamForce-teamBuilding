package com.sansam.project.command.application.dto;


import com.sansam.project.command.domain.aggregate.BoardStatus;
import com.sansam.project.command.domain.aggregate.entity.ProjectBoard;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminProjectBoardUpdateDTO {

    private String projectBoardTitle;
    private String projectBoardContent;
    private int projectBoardHeadCount;
    private String projectBoardImgUrl;
    private LocalDateTime projectBoardStartDate;
    private LocalDateTime projectBoardEndDate;
    private BoardStatus boardStatus;
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;

    public AdminProjectBoardUpdateDTO(ProjectBoard projectBoard) {
    }
}