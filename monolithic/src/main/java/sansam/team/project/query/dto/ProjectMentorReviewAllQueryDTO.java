package sansam.team.project.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMentorReviewAllQueryDTO {

    private Long mentorReviewSeq;
    private String userName;
    private double mentorReviewStar;
    private String mentorReviewContent;
}
