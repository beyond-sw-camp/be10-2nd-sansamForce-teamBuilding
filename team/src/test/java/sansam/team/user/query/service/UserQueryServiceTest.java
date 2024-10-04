package sansam.team.user.query.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sansam.team.user.command.domain.aggregate.entity.User;

class UserQueryServiceTest {

    private UserQueryService userQueryService;

    private User user;


    @BeforeEach
    public void setUp() {
        this.user = new User();
    }

    @Test
    void findById() {
        /*UserQueryDTO.LoginRequestDTO login = new UserQueryDTO.LoginRequestDTO("test", "Test");

        UserQueryDTO.LoginResponseDTO result = userQueryService.findById(login);

        assertNotNull(result);*/
    }


}