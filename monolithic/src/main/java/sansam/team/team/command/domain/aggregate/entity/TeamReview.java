package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user_review")
public class TeamReview extends BaseTimeEntity {

    @Id @Column(name = "user_review_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userReviewSeq;

    @Column(name = "send_team_member_seq")
    private long sendMemberSeq;

    @Column(name = "receive_team_member_seq")
    private long receiveMemberSeq;

    @Column(name = "team_member_review_star")
    private double reviewStar;

    @Column(name = "team_member_review_content")
    private String reviewContent;

    public void updateReview(long receiveMemberSeq, double reviewStar, String reviewContent) {
        this.receiveMemberSeq = receiveMemberSeq;
        this.reviewStar = reviewStar;
        this.reviewContent = reviewContent;
    }

}
