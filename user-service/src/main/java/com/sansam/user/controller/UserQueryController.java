package com.sansam.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserQueryController {

    private final Environment env;

    @GetMapping("/health")
    public String health() {
        return "I'm Working in User Service " + env.getProperty("local.server.port");
    }
}
