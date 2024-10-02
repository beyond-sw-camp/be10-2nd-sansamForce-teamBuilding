package sansam.team.user.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.user.query.dto.UserGithubRepositoryQueryDTO;

import java.util.List;

@Mapper
public interface UserGithubRepositoryMapper {
    List<UserGithubRepositoryQueryDTO> findAllGithubRepo();
}
