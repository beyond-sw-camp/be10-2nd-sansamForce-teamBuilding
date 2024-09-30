package sansam.team.team.query.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sansam.team.common.aggregate.entity.BaseTimeEntity;
import sansam.team.team.command.domain.aggregate.TeamStatusType;

import java.time.LocalDateTime;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class TeamQueryDTO extends BaseTimeEntity {
    private long teamSeq;
    private long projectSeq;
    private long ruleSeq;
    private String teamName;
    private TeamStatusType teamStatus;
    private LocalDateTime endDate;
}