package sansam.team.team.command.domain.aggregate.entity;

import jakarta.persistence.*;
import sansam.team.common.BaseTimeEntity;

@Entity
@Table(name = "tbl_user_review")
public class TeamReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
