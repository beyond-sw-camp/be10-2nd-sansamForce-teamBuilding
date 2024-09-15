package sansam.team.test.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.test.command.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndPassword(String id, String password);

}
