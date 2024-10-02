package sansam.team.user.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.user.query.dto.UserGithubRepositoryQueryDTO;
import sansam.team.user.query.mapper.UserGithubRepositoryQueryMapper;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGithubRepositoryQueryService {

    private final UserGithubRepositoryQueryMapper userGithubRepositoryQueryMapper;

    public List<UserGithubRepositoryQueryDTO> getAllGithubRepo(Long userSeq) {
        return userGithubRepositoryQueryMapper.findAllGithubRepoByUserSeq(userSeq);
    }
}
