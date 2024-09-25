package sansam.team.user.command.application.dto.mypagedto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyPageDTO {

    @NotNull
    private Long userSeq;
    private String userNickname;
    private String userPassword;
    private String userPhone;
    @Email
    private String userEmail;
    private String userGithubId;
    private String userProfileImg;
}

