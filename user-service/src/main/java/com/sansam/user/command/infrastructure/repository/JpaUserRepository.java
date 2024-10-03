package com.sansam.user.command.infrastructure.repository;


import com.sansam.user.command.domain.aggregate.entity.User;
import com.sansam.user.command.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRepository extends UserRepository, JpaRepository<User, Long> {


}
