package sansam.team.team.command.entity;

import jakarta.persistence.*;
import sansam.team.common.BaseTimeEntity;

@Entity
@Table(name = "tbl_team_member_schedule_progress")
@SequenceGenerator(
        name = "TEAM_MEMBER_SCHEDULE_PROGRESS_SEQ_GENERATOR"
        , sequenceName = "TEAM_MEMBER_SCHEDULE_PROGRESS_SEQ"
        , allocationSize = 1)
public class TeamMemberScheduleProgress extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "TEAM_MEMBER_SCHEDULE_PROGRESS_SEQ_GENERATOR")
    private long teamMemberScheduleProgressSeq;
    private long teamScheduleSeq;
    private long teamMemberSeq;
    @Column(name = "team_schedule_progress_content")
    private String progressContent;
    @Column(name = "team_schdeule_progress_feedback")
    private String progressFeedback;
}
