package com.sansam.project.command.application.service;


import com.sansam.project.command.application.dto.AdminProjectApplyMemberDTO;
import com.sansam.project.command.domain.aggregate.entity.ProjectApplyMember;
import com.sansam.project.command.domain.aggregate.entity.ProjectBoard;
import com.sansam.project.command.domain.repository.ProjectApplyMemberRepository;
import com.sansam.project.command.domain.repository.ProjectBoardRepository;
import com.sansam.project.command.mapper.ProjectApplyMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectApplyMemberService {

    private final ProjectApplyMemberRepository projectApplyMemberRepository;
    private final ProjectBoardRepository projectBoardRepository;


    @Transactional
    public ProjectApplyMember applyForProject(AdminProjectApplyMemberDTO applyMemberDTO) {

        // SecurityContext에서 현재 인증된 사용자(User 객체) 추출
        CustomUserDTO user = SecurityUtil.getAuthenticatedUser();

        // 추출한 User의 userSeq가 null이 아닌지 확인
        if(ObjectUtils.isEmpty(user.getUserSeq())){
            throw new IllegalArgumentException("User Seq is null");
        }

        ProjectApplyMember projectApplyMember = ProjectApplyMemberMapper.toEntity(user.getUserSeq(), applyMemberDTO);

        projectApplyMemberRepository.save(projectApplyMember);

        return projectApplyMember;
    }

    @Transactional
    public void cancelApplication(Long projectBoardSeq) {

        // SecurityContext에서 현재 인증된 사용자(User 객체) 추출
        CustomUserDTO user = SecurityUtil.getAuthenticatedUser();

        // 추출한 User의 userSeq가 null이 아닌지 확인
        if (user.getUserSeq() == null) {
            throw new IllegalArgumentException("User Seq is null");
        }

        // 기존 프로젝트 보드를 찾음
        ProjectBoard projectBoard = projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));

        projectApplyMemberRepository.deleteById(projectBoardSeq);

    }
}