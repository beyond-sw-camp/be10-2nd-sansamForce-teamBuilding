package com.sansam.team.command.application.dto;


import com.sansam.team.command.domain.aggregate.TeamStatusType;
import com.sansam.team.common.aggregate.entity.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeamDTO extends BaseTimeEntity {

    private long teamSeq;

    private long projectSeq;

    private long ruleSeq;

    private String teamName;

    private TeamStatusType teamStatus;

    private LocalDateTime endDate;

}
