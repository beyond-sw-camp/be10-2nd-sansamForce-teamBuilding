package sansam.team.project.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.query.dto.ApplyMemberQueryDTO;
import sansam.team.project.query.mapper.ProjectApplyMemberMapper;
import sansam.team.security.util.SecurityUtil;
import sansam.team.user.query.dto.CustomUserDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectApplyMemberQueryService {

    private final ProjectApplyMemberMapper projectApplyMemberMapper;


    // JWT 대신 SecurityContextHolder에서 userSeq를 가져와서 프로젝트 목록을 조회하는 메서드
    public List<ApplyMemberQueryDTO> findProjectsByCurrentUser() {
        CustomUserDTO user = SecurityUtil.getAuthenticatedUser(); // SecurityContext에서 인증된 사용자 가져오기
        Long userSeq = user.getUserSeq(); // User 객체에서 userSeq 추출
        return projectApplyMemberMapper.findProjectsByUserSeq(userSeq);
    }
}
