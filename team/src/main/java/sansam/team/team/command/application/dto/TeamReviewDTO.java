package sansam.team.team.command.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sansam.team.common.BaseTimeEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamReviewDTO extends BaseTimeEntity {
    private long userReviewSeq;
    private long sendTeamMemberSeq;
    private long receiveTeamMemberSeq;
    private double teamMemberReviewStar;
    private String teamMemberReviewContent;
}
