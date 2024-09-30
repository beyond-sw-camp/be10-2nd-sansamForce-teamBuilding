package sansam.team.team.command.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamReviewDTO extends BaseTimeEntity {
    private long userReviewSeq;
    private long sendMemberSeq;
    private long receiveMemberSeq;
    private double reviewStar;
    private String reviewContent;
}
