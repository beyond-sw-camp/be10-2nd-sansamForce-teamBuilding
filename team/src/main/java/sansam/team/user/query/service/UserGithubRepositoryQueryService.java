package sansam.team.user.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.query.dto.ProjectAllQueryDTO;
import sansam.team.user.command.domain.aggregate.entity.UserGithubRepository;
import sansam.team.user.query.dto.UserGithubRepositoryQueryDTO;
import sansam.team.user.query.mapper.UserGithubRepositoryMapper;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGithubRepositoryQueryService {

    private final UserGithubRepositoryMapper userGithubRepositoryMapper;

    /* 프로젝트 전체 조회 (관리자) */
    public List<UserGithubRepositoryQueryDTO> getAllGithubRepo() {
        return userGithubRepositoryMapper.findAllGithubRepo();
    }

}
