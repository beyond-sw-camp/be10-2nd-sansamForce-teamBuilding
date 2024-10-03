package com.sansam.team.command.application.dto;


import com.sansam.team.common.aggregate.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TeamReviewDTO extends BaseTimeEntity {

    private long userReviewSeq;

    private long sendMemberSeq;

    private long receiveMemberSeq;

    private double reviewStar;

    private String reviewContent;

}
