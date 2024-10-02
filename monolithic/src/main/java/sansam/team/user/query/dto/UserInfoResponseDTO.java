package sansam.team.user.query.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoResponseDTO {
    private Long userSeq;
    private String userId;
    private String userName;
    private String userNickname;
    private String userEmail;
    private String userPhone;
    private String userMajor;
}
