package sansam.team.project.command.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectMentorReviewUpdateDTO {

    private double mentorReviewStar;
    private String mentorReviewContent;
}