package sansam.team.user.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.user.command.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndPassword(String id, String password);
    Optional<User> findById(String id);

}
