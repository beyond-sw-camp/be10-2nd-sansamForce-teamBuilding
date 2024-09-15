package sansam.team.user.command.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.user.command.dto.UserDTO;
import sansam.team.user.command.entity.User;
import sansam.team.user.command.service.UserService;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = {"/login"})
    public ResponseEntity<String> login(@RequestParam String id, @RequestParam String pw) {
        User user = userService.loginProcess(id, pw);
        if(user == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok("login");
    }

    @PostMapping(value = {"/join"})
    public ResponseEntity<String> joinProcess(@RequestBody UserDTO userDTO) {
        boolean isJoinMember = userService.joinProcess(userDTO);

        return ResponseEntity.status(isJoinMember ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
                .body(isJoinMember ? "join member successfully" : " Error join member");
    }


}
