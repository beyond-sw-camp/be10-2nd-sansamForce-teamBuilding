package sansam.team.buildingrule.command.domain.domain.aggregate;


import jakarta.persistence.*;
import lombok.*;
import sansam.team.common.BaseTimeEntity;
import sansam.team.common.YnType;


@Entity
@Table(name = "tbl_building_rule")
@Getter
@NoArgsConstructor
public class BuildingRule extends BaseTimeEntity, YnType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ruleSeq;
    private int ruleTeamCount;
    private int ruleMajorWeight;
    private int ruleCareerWeight;
    private int ruleGithubWeight;
    private int ruleTeamReviewWeight;
    private int ruleMentorReviewWeight;

    private YnType ruleTechStackYn;


}

