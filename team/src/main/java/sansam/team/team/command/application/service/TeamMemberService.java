package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.exception.CustomNotFoundException;
import sansam.team.exception.ErrorCodeType;
import sansam.team.team.command.domain.aggregate.entity.TeamMember;
import sansam.team.team.command.domain.repository.TeamMemberRepository;

@Service
@RequiredArgsConstructor
public class TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;

    @Transactional
    public TeamMember getTeamMemberByUserId(Long memberSeq) throws CustomNotFoundException {
        return teamMemberRepository.findByUserSeq(memberSeq)
                .orElseThrow(() -> new CustomNotFoundException(ErrorCodeType.MEMBER_NOT_FOUND));
    }

}
