package sansam.team.project.command.application.dto.mentor;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MentorReviewCreateDTO {

    private Long projectMemberSeq;
    private double mentorReviewStar;
    private String mentorReviewContent;
}
