package com.sansam.project.query.dto;


import com.sansam.project.command.domain.aggregate.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectQueryDTO {

    private Long projectSeq;
    private String projectTitle;
    private String projectContent;
    private ProjectStatus projectStatus;
    private int projectHeadCount;
    private String projectImgUrl;
    private LocalDateTime projectStartDate;
    private LocalDateTime projectEndDate;
}