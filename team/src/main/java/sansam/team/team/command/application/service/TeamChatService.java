package sansam.team.team.command.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.team.command.application.dto.TeamChatCreateRequestDTO;
import sansam.team.team.command.application.dto.TeamChatUpdateRequestDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamChat;
import sansam.team.team.command.domain.repository.TeamChatRepository;
import sansam.team.team.command.mapper.TeamChatMapper;

@Service
@RequiredArgsConstructor
public class TeamChatService {

    private final TeamChatRepository teamChatRepository;

    @Transactional
    public TeamChat createTeamChat(Long teamSeq, TeamChatCreateRequestDTO teamChatDTO) {
        TeamChat teamChat = TeamChatMapper.toEntity(teamSeq, teamChatDTO);

        teamChatRepository.save(teamChat);

        return teamChat;
    }

    @Transactional
    public TeamChat updateTeamChat(Long teamChatSeq, TeamChatUpdateRequestDTO teamChatDTO) {
        TeamChat teamChat = teamChatRepository.findById(teamChatSeq).orElseThrow();

        teamChat.modifyTeamChat(teamChatDTO.getTeamChatName(), teamChatDTO.getTeamChatComment());

        return teamChat;
    }

    @Transactional
    public void deleteTeamChat(Long teamChatSeq) {
        teamChatRepository.deleteById(teamChatSeq);
    }
}
