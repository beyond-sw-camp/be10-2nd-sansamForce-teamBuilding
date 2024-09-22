package sansam.team.team.command.application.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sansam.team.common.YnType;
import sansam.team.team.command.application.dto.TeamChatCreateRequestDTO;
import sansam.team.team.command.application.dto.TeamChatUpdateRequestDTO;
import sansam.team.team.command.domain.aggregate.entity.TeamChat;
import sansam.team.team.command.domain.repository.TeamChatRepository;


@SpringBootTest
class TeamChatServiceTest {

    @Autowired
    TeamChatService teamChatService;
    @Autowired
    TeamChatRepository teamChatRepository;

    @Test
    void teamChatCreateTest() {
        System.out.println("테스트 시작");
        TeamChatCreateRequestDTO teamChatDTO =
                new TeamChatCreateRequestDTO(1L, "킹왕짱 채팅방", "안녕하세요 킹왕짱 채팅방입니다.", YnType.Y);

        teamChatService.createTeamChat(teamChatDTO);
        System.out.println("테스트 종료");
    }

    @Test
    void teamChatUpdateTest() {
        TeamChat teamChat = teamChatRepository.findById(1L).orElseThrow();

        TeamChatUpdateRequestDTO teamChatDTO = new TeamChatUpdateRequestDTO();
        teamChatDTO.setTeamChatName("팀 채팅방 이름");
        teamChatDTO.setTeamChatComment("팀 채팅방 설명");

        teamChatService.updateTeamChat(teamChat.getTeamChatSeq(), teamChatDTO);
    }
}