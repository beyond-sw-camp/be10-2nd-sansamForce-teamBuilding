package com.sansam.team.command.infrastructure.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamMember;
import com.sansam.team.command.domain.repository.TeamMemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTeamMemberRepository extends TeamMemberRepository, JpaRepository<TeamMember, Long> {
}
