package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user_review")
public class TeamReview extends BaseTimeEntity {

    @Id @Column(name = "user_review_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userReviewSeq;

    @Column(name = "send_team_member_seq")
    private Long sendMemberSeq;

    @Column(name = "receive_team_member_seq")
    private Long receiveMemberSeq;

    @Column(name = "team_member_review_star")
    private Long reviewStar;

    @Column(name = "team_member_review_content")
    private Long reviewContent;

}
