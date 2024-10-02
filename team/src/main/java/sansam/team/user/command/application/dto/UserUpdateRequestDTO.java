package sansam.team.user.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserUpdateRequestDTO {

    private Long majorSeq;
    private String userNickname;
    private String userPhone;
    private String userEmail;
    private String userGithubId;
    private String userProfileImg;
    private Long userCareerYears;
    private Long userCareerMonths;

}

