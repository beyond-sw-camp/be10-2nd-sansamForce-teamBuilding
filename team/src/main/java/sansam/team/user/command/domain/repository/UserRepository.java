package sansam.team.user.command.domain.repository;

import sansam.team.user.command.domain.aggregate.entity.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);
}
