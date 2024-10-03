package sansam.team.user.query.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.query.dto.UserQueryDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Testcontainers
class UserQueryServiceTest {

    private UserQueryService userQueryService;

    private User user;


    @BeforeEach
    public void setUp() {
        this.user = new User();
    }

    @Test
    void findById() {
        UserQueryDTO.LoginRequestDTO login = new UserQueryDTO.LoginRequestDTO("test", "Test");

        UserQueryDTO.LoginResponseDTO result = userQueryService.findById(login);

        assertNotNull(result);
        assertEquals(login.getId(), result.getUserId());
    }


}