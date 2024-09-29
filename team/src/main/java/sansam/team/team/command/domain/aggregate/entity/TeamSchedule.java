package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamSchedule extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long teamScheduleSeq;
    private long teamSeq;
    @Column(name = "team_schedule_content")
    private long content;
    @Column(name = "team_schedule_start_date")
    private LocalDateTime startDate;
    @Column(name = "team_schedule_end_date")
    private LocalDateTime endDate;
}
