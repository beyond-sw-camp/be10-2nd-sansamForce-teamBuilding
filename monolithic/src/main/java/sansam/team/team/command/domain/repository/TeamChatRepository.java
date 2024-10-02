package sansam.team.team.command.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.aggregate.entity.TeamChat;

import java.util.Optional;

public interface TeamChatRepository extends JpaRepository<TeamChat, Long> {
}
