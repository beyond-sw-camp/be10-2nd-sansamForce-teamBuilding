package sansam.team.user.command.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.user.command.dto.*;
import sansam.team.user.command.service.UserService;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //로그인 페이지 진입 호출 메소드
    @GetMapping(value = {"", "/", "/login"})
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("login");
    }

    // 로그인 요청 처리 메소드
    @PostMapping(value = {"/login"})
    public ResponseEntity<LoginResponseDTO> loginProcess(@RequestBody LoginRequestDTO loginRequestDTO) throws JsonProcessingException {
        JwtToken token = userService.loginProcess(loginRequestDTO);
        if(token == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        // 로그인 성공 시 필요한 사용자 정보와 JWT 토큰을 포함한 응답을 반환
        UserDTO userDTO = userService.findById(loginRequestDTO);  // 서비스에서 사용자를 조회
        LoginResponseDTO loginResponse = new LoginResponseDTO(userDTO.getId(),userDTO.getName(), userDTO.getAuth(), token);

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping(value = {"/join"})
    public ResponseEntity<String> joinProcess(@RequestBody UserJoinDTO userJoinDTO) {
        boolean isJoinMember = userService.joinProcess(userJoinDTO);
        return ResponseEntity.status(isJoinMember ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
                .body(isJoinMember ? "Join successful" : "Error during registration");
    }


}
