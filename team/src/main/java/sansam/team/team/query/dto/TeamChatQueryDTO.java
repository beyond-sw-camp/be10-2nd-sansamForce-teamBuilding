package sansam.team.team.query.dto;

import lombok.*;
import sansam.team.common.aggregate.RoleType;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamChatQueryDTO {
    Long userSeq;
    RoleType roleType;
}
