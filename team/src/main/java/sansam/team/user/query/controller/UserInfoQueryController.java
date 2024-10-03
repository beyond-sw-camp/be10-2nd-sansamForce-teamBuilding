package sansam.team.user.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.common.response.ApiResponse;
import sansam.team.user.query.dto.UserInfoResponseDTO;
import sansam.team.user.query.service.UserInfoQueryService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user/{userSeq}/info")
@Tag(name = "1-1. User API", description = "회원 API")
public class UserInfoQueryController {

    private final UserInfoQueryService userInfoQueryService;

    @GetMapping
    @Operation(summary = "마이페이지", description = "마이페이지 API")
    public ApiResponse<UserInfoResponseDTO> getUserInfo(@PathVariable Long userSeq) {
        UserInfoResponseDTO userInfo = userInfoQueryService.getUserInfo(userSeq);
        return ApiResponse.ofSuccess("User information retrieved successfully", userInfo);
    }
}
