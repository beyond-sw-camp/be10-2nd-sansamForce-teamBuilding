package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_team_schedule")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamSchedule extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_schedule_seq")
    private long teamScheduleSeq;

    @Column(name = "team_seq")
    private long teamSeq;

    @Column(name = "team_schedule_content")
    private String content;

    @Column(name = "team_schedule_start_date")
    private LocalDateTime startDate;

    @Column(name = "team_schedule_end_date")
    private LocalDateTime endDate;

    public void updateSchedule(String content, LocalDateTime startDate, LocalDateTime endDate) {
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
