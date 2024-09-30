package sansam.team.major.command.domain.repository;

import sansam.team.major.command.domain.aggregate.Major;

import java.util.Optional;

public interface MajorRepository {
    Major save(Major major);
    Optional<Major> findById(Long majorSeq);
    void delete(Major major);
}
