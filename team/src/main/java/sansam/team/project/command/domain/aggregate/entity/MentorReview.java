package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;
import sansam.team.project.command.application.dto.mentor.MentorReviewCreateDTO;
import sansam.team.project.command.application.dto.mentor.MentorReviewUpdateDTO;

@Entity
@Table(name = "tbl_mentor_review")
@Getter
@NoArgsConstructor
public class MentorReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentorReviewSeq;                           // 프로젝트 강사 평가 번호

    private Long projectMemberSeq;                          // 프로젝트 회원 번호

    private Long projectMentorSeq;                          // 프로젝트 강사 번호

    private double mentorReviewStar;                        // 강사 평가 별점

    private String mentorReviewContent;                     // 강사 평가 상세 내용


    public void projectMentorSeq(Long projectMentorSeq) {
        this.projectMentorSeq = projectMentorSeq;
    }

    public void projectUserSeq(Long projectMemberSeq) {
        this.projectMemberSeq = projectMemberSeq;
    }


    public void updateMentorReview(MentorReviewUpdateDTO mentorReviewUpdateDTO) {
        this.mentorReviewStar = mentorReviewUpdateDTO.getMentorReviewStar();
        this.mentorReviewContent = mentorReviewUpdateDTO.getMentorReviewContent();
    }

}
