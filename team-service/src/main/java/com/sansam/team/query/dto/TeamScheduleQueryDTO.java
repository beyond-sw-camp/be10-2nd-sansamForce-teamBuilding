package com.sansam.team.query.dto;


import com.sansam.team.common.aggregate.entity.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamScheduleQueryDTO extends BaseTimeEntity {
    private long teamScheduleSeq;
    private long teamSeq;
    private String teamScheduleContent;
    private LocalDateTime teamScheduleStartDate;
    private LocalDateTime teamScheduleEndDate;
}
