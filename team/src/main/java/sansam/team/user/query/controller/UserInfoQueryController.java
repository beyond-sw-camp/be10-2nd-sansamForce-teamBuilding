package sansam.team.user.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ApiResponse;
import sansam.team.user.query.dto.UserInfoResponseDTO;
import sansam.team.user.query.service.UserInfoQueryService;

@RestController
@RequestMapping("/api/v1/query/user")
@Tag(name = "1. User API", description = "회원 API")
public class UserInfoQueryController {

    private final UserInfoQueryService userInfoQueryService;

    @Autowired
    public UserInfoQueryController(UserInfoQueryService userInfoQueryService) {
        this.userInfoQueryService = userInfoQueryService;
    }

    @PostMapping("/{userId}")
    @Operation(summary = "마이페이지", description = "마이페이지 API")
    public ResponseEntity<ApiResponse<UserInfoResponseDTO>> getUserInfo(@PathVariable String userId) {
        return userInfoQueryService.getUserInfo(userId);
    }
}
