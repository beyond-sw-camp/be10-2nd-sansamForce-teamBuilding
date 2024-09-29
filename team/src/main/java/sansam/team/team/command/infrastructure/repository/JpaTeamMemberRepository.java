package sansam.team.team.command.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.domain.aggregate.entity.TeamMember;
import sansam.team.team.command.domain.repository.TeamMemberRepository;

public interface JpaTeamMemberRepository extends TeamMemberRepository, JpaRepository<TeamMember, Long> {
}
