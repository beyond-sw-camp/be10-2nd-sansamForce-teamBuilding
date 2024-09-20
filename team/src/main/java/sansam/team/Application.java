package sansam.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/* spring security 사용 시 괄호 부분 삭제할 것!
 *  지금 상태는 security를 사용하지 않아 잠시 설정해둔 상태임 */
@SpringBootApplication
@EnableJpaAuditing
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
