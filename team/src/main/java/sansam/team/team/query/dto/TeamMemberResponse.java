package sansam.team.team.query.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamMemberResponse {
    private Long teamMemberSeq;
    private String userNickname;
    private String userPhone;
    private String userBirthDate;
    private String userGender;
    private String userGithubId;
}
