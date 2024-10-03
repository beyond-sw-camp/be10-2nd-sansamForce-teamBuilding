package com.sansam.user.command.application.controller;


import com.sansam.user.command.application.dto.UserGithubRepositoryDTO;
import com.sansam.user.command.application.service.UserGithubRepositoryService;
import com.sansam.user.command.domain.aggregate.entity.UserGithubRepository;
import com.sansam.user.common.response.ApiResponse;
import com.sansam.user.common.response.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/user/{userSeq}/githubRepository")
@RequiredArgsConstructor
@Tag(name = "1-2. User GitHub Repository API", description = "유저 깃허브 레포지토리 API")
public class UserGithubRepositoryController {

    private final UserGithubRepositoryService userGithubRepositoryService;

    @PostMapping
    @Operation(summary = "깃허브 레포지토리 추가")
    public ApiResponse<?> createGithubRepo(@RequestBody UserGithubRepositoryDTO dto) {
        UserGithubRepository userGithubRepository = userGithubRepositoryService.createRepository(dto);
        return ResponseUtil.successResponse(userGithubRepository).getBody();
    }

    @PutMapping("/{userGithubRepositorySeq}")
    @Operation(summary = "깃허브 레포지토리 이름, url, 개발 분야 변경")
    public ApiResponse<?> updateGithubRepo(@PathVariable Long userGithubRepositorySeq, @RequestBody UserGithubRepositoryDTO dto) {
        UserGithubRepository userGithubRepository = userGithubRepositoryService.updateRepository(userGithubRepositorySeq, dto);
        return ResponseUtil.successResponse(userGithubRepository).getBody();
    }

    @DeleteMapping("/{userGithubRepositorySeq}")
    @Operation(summary = "깃허브 레포지토리 삭제")
    public ApiResponse<?> deleteGithubRepo(@PathVariable Long userGithubRepositorySeq) {
        userGithubRepositoryService.deleteRepository(userGithubRepositorySeq);
        return ResponseUtil.successResponse("삭제 성공").getBody();
    }
}
