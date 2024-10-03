package com.sansam.team.command.domain.repository;


import com.sansam.team.command.domain.aggregate.entity.TeamChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamChatRepository extends JpaRepository<TeamChat, Long> {
}
