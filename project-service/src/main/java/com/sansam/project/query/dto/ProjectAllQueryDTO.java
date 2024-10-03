package com.sansam.project.query.dto;


import com.sansam.project.command.domain.aggregate.ProjectStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectAllQueryDTO {

    private Long projectSeq;
    private String projectTitle;
    private ProjectStatus projectStatus;
    private String projectImgUrl;

}