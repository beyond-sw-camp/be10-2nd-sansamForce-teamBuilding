package com.sansam.team.client.dto;

import com.sansam.team.common.aggregate.DevelopType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGithubRepositoryDTO {
    private String userRepositoryUrl;
    private String userRepositoryName;
    private DevelopType developType;
}
