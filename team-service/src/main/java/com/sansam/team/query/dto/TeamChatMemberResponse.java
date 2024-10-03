package com.sansam.team.query.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamChatMemberResponse {
    private String userName;
    private String userNickname;
    private String userPhone;
    private String userEmail;
    private String userBirthDate;
    private String userGender;
    private String userGithubId;
    private String userProfileImg;
}
