package com.sansam.user.query.mapper;


import com.sansam.user.query.dto.UserGithubRepositoryQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserGithubRepositoryQueryMapper {
    List<UserGithubRepositoryQueryDTO> findAllGithubRepoByUserSeq(long userSeq);
}
