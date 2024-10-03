package com.sansam.user.query.controller;

import com.sansam.user.command.application.dto.UserDTO;
import com.sansam.user.command.application.service.UserService;
import com.sansam.user.query.service.UserQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@Tag(name = "1-1. User API", description = "회원 API")
public class UserQueryController {

    private final Environment env;
    private final UserQueryService userQueryService;

    @GetMapping("/health")
    public String health() {
        return "I'm Working in User Service " + env.getProperty("local.server.port");
    }

    @GetMapping("/{userSeq}")
    public UserDTO findUserById(@PathVariable Long userSeq) {
        return userQueryService.findById(userSeq);
    }
}
