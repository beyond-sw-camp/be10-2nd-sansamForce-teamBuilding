package com.sansam.team.command.application.dto;


import com.sansam.team.common.aggregate.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TeamScheduleDTO extends BaseTimeEntity {

    private long teamScheduleSeq;

    private long teamSeq;

    private String scheduleContent;

    private LocalDateTime scheduleStartDate;

    private LocalDateTime scheduleEndDate;

}
