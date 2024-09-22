package sansam.team.user.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.command.domain.repository.UserRepository;

import java.util.Optional;

public interface JpaUserRepository extends UserRepository, JpaRepository<User, Long> {


}
