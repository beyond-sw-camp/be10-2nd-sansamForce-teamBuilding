package sansam.team.user.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.user.command.application.dto.*;
import sansam.team.user.command.application.service.UserService;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "User API", description = "회원 API")
public class UserController {

    private final UserService userService;

    @PostMapping(value = {"/join"})
    @Operation(summary = "회원가입", description = "회원가입 API")
    public ResponseEntity<String> joinProcess(@RequestBody UserDTO.UserJoinDTO userJoinDTO) {
        boolean isJoinMember = userService.joinProcess(userJoinDTO);
        return ResponseEntity.status(isJoinMember ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
                .body(isJoinMember ? "Join successful" : "Error during registration");
    }

}
