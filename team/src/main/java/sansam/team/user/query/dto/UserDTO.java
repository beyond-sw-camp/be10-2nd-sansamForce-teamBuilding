package sansam.team.user.query.dto;

import sansam.team.user.command.enums.RoleType;
import sansam.team.user.command.enums.StatusType;

import java.time.LocalDateTime;

public class UserDTO {

    private Long userSeq;

    private String id;

    private String name;

    private String nickname;

    private String password;

    private RoleType auth = RoleType.MEMBER;

    private String phone;

    private String email;

    private String birthDate;

    private String gender;

    private String githubId;

    private String profileImg;

    private StatusType status = StatusType.ACTIVE;

    private LocalDateTime pwdModDate;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private LocalDateTime banDate;

    private LocalDateTime delDate;

}
