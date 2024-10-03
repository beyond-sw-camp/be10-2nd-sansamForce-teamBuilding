package com.sansam.user.command.domain.repository;

import com.sansam.user.command.domain.aggregate.entity.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);

    Optional<User> findById(Long userSeq);
}
