package com.sansam.team.client;

import com.sansam.team.client.dto.UserDTO;
import com.sansam.team.client.dto.UserGithubRepositoryDTO;
import com.sansam.team.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service", url = "localhost:8000", configuration = FeignClientConfig.class)
public interface UserServiceClient {
    @GetMapping("/api/v1/user/{userSeq}")
    UserDTO findUserById(@PathVariable Long userSeq);

    @GetMapping("/api/v1/user/{userSeq}/GithubRepository")
    List<UserGithubRepositoryDTO> findAllGithubRepositoryByUserSeq(@PathVariable Long userSeq);
}
