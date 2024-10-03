package com.sansam.team.query.dto;


import com.sansam.team.common.aggregate.RoleType;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamChatRequest {
    Long userSeq;
    RoleType roleType;
}
