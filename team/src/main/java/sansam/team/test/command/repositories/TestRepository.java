package sansam.team.test.command.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.test.command.entities.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
