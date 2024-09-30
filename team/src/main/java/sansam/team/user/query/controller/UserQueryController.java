package sansam.team.user.query.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.user.query.dto.UserQueryDTO;
import sansam.team.user.query.service.UserQueryService;

@Slf4j
@RestController
@RequestMapping("/api/v1/query/user")
@RequiredArgsConstructor
@Tag(name = "1. User API", description = "회원 API")
public class UserQueryController {

    private final UserQueryService userQueryService;

    @PostMapping(value = {"/login"})
    @Operation(summary = "로그인", description = "로그인 API")
    public ResponseEntity<UserQueryDTO.LoginResponseDTO> loginProcess(@RequestBody UserQueryDTO.LoginRequestDTO loginRequestDTO) throws JsonProcessingException {
        UserQueryDTO.LoginResponseDTO user = userQueryService.loginProcess(loginRequestDTO);
        if(user == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity.ok(user);
    }
}
