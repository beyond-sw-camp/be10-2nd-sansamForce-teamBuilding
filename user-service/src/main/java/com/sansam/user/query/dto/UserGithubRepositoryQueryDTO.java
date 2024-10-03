package com.sansam.user.query.dto;


import com.sansam.user.common.aggregate.DevelopType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserGithubRepositoryQueryDTO {
    private String userRepositoryUrl;
    private String userRepositoryName;
    private DevelopType developType;
}
