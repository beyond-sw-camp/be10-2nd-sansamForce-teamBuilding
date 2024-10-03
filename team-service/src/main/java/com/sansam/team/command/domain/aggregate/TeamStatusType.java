package com.sansam.team.command.domain.aggregate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TeamStatusType {
    OPEN("활성화"),
    CLOSE("비활성화");

    private final String teamStatus;
}
