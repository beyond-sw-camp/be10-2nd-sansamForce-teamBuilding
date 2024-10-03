package com.sansam.project.query.service;


import com.sansam.project.query.dto.ApplyMemberQueryDTO;
import com.sansam.project.query.mapper.ProjectApplyMemberQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectApplyMemberQueryService {

    private final ProjectApplyMemberQueryMapper projectApplyMemberMapper;


    // JWT 대신 SecurityContextHolder에서 userSeq를 가져와서 프로젝트 목록을 조회하는 메서드
    public List<ApplyMemberQueryDTO> findProjectsByCurrentUser() {
        CustomUserDTO user = SecurityUtil.getAuthenticatedUser(); // SecurityContext에서 인증된 사용자 가져오기
        Long userSeq = user.getUserSeq(); // User 객체에서 userSeq 추출
        return projectApplyMemberMapper.findProjectsByUserSeq(userSeq);
    }
}