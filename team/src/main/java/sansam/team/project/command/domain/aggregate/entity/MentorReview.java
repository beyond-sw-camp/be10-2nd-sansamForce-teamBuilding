package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

@Entity
@Table(name = "tbl_mentor_review")
@Getter
@NoArgsConstructor
public class MentorReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentorReviewSeq;                           // 프로젝트 강사 평가 번호

    private Long projectUserSeq;                          // 프로젝트 회원 번호

    private Long projectMentorSeq;                          // 프로젝트 강사 번호

    private double mentorReviewStar;                        // 강사 평가 별점

    private String mentorReviewContent;                     // 강사 평가 상세 내용


    public void projectMentorSeq(Long projectMentorSeq) {
        this.projectMentorSeq = projectMentorSeq;
    }

    public void projectUserSeq(Long userSeq) {
        this.projectUserSeq = userSeq;
    }


}
