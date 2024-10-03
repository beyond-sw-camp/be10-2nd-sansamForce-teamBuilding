package com.sansam.project.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMentorReviewQueryDTO {

    private String userName;
    private double mentorReviewStar;
    private String mentorReviewContent;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}