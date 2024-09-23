package sansam.team.buildingrule.command.domain.aggregate;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "tbl_building_rule")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BuildingRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ruleSeq;

    private int ruleTeamCount;

    private int ruleMajorWeight;

    private int ruleCareerWeight;

    private int ruleGithubWeight;

    private int ruleTeamReviewWeight;

    private int ruleMentorReviewWeight;

    private String ruleTechStackYn;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

}

