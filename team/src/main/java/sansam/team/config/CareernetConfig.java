package sansam.team.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class CareernetConfig {
    @Value("${careernet.api.key}")
    private String apiKey;

}
