package com.sansam.project.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectMentorReviewCreateDTO {

    private Long projectMemberSeq;
    private double mentorReviewStar;
    private String mentorReviewContent;
}