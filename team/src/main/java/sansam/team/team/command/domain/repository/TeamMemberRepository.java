package sansam.team.team.command.domain.repository;

import sansam.team.team.command.domain.aggregate.entity.TeamMember;

import java.util.Optional;

public interface TeamMemberRepository {
    Optional<TeamMember> findByUserSeq(long userSeq);

    Optional<TeamMember> findById(long teamMemberSeq);

    void deleteById(Long teamMemberSeq);

    TeamMember save(TeamMember teamMember);
}
