package sansam.team.team.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TeamBuildingDTO {
    private Long userSeq;
    private Long projectMemberSeq;
    private int totalScore;

    public TeamBuildingDTO(Long userSeq, Long projectMemberSeq) {
        this.userSeq = userSeq;
        this.projectMemberSeq = projectMemberSeq;
    }

}
