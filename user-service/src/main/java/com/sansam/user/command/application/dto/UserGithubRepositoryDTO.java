package com.sansam.user.command.application.dto;

import com.sansam.user.common.aggregate.DevelopType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserGithubRepositoryDTO {
    private long userSeq;
    private String userRepositoryUrl;
    private String userRepositoryName;
    private DevelopType developType;
}
