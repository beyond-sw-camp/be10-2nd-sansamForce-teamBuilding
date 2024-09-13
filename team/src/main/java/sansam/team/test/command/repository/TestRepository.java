package sansam.team.test.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.test.command.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}
