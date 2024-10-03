package sansam.team.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GithubConfig {

    @Value("${github.token}")
    private String githubToken;

    @Bean
    public String githubToken() {
        return githubToken;
    }
}