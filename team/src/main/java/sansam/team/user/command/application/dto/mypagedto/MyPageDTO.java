package sansam.team.user.command.application.dto.mypagedto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class MyPageDTO {

    private String userNickname;
    private String userPassword;
    private String userPhone;
    private String userEmail;
    private String userGithubId;
    private String userProfileImg;
    private Long userCareerYears;
    private Long userCareerMonths;

}

