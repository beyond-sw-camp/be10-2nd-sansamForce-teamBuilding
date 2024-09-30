package sansam.team.major.command.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.major.command.domain.aggregate.Major;
import sansam.team.major.command.domain.repository.MajorRepository;

public interface JpaMajorRepository extends JpaRepository<Major, Long>, MajorRepository {
}
