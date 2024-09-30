package sansam.team.team.command.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamScheduleDTO extends BaseTimeEntity {
    private long teamScheduleSeq;
    private long teamSeq;
    private String scheduleContent;
    private LocalDateTime scheduleStartDate;
    private LocalDateTime scheduleEndDate;
}
