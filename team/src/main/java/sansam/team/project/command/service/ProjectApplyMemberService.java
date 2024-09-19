package sansam.team.project.command.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.project.command.entity.ProjectApplyMember;
import sansam.team.project.command.entity.ProjectBoard;
import sansam.team.project.command.enums.ApplyStatus;
import sansam.team.project.command.repository.ProjectApplyMemberRepository;
import sansam.team.project.command.repository.ProjectBoardRepository;
import sansam.team.user.command.entity.User;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProjectApplyMemberService {

    private final ProjectApplyMemberRepository projectApplyMemberRepository;
    private final ProjectBoardRepository projectBoardRepository;

    // 인증된 사용자(User)를 가져오는 메서드
    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    // ProjectBoard를 조회하는 메서드
    private ProjectBoard getProjectBoard(Long projectBoardSeq) {
        return projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));
    }

    @Transactional
    public ProjectApplyMember applyForProject(Long projectBoardSeq) {

        // 인증된 사용자 추출
        User user = getAuthenticatedUser();

        // ProjectBoardSeq로 ProjectBoard 엔티티 조회
        ProjectBoard projectBoard = getProjectBoard(projectBoardSeq);

        // ProjectApplyMember 생성
        ProjectApplyMember projectApplyMember = new ProjectApplyMember(
                null,
                ApplyStatus.APPLIED,
                user,
                projectBoard,
                null // Auditable 자동 처리
        );

        return projectApplyMemberRepository.save(projectApplyMember);
    }

    @Transactional
    public void cancelApplication(Long projectBoardSeq) {

        // 인증된 사용자 추출
        User user = getAuthenticatedUser();

        // ProjectBoardSeq로 ProjectBoard 엔티티 조회
        ProjectBoard projectBoard = getProjectBoard(projectBoardSeq);

        // userSeq와 projectBoard로 ProjectApplyMember 조회
        ProjectApplyMember applyMember = projectApplyMemberRepository.findByUser_UserSeqAndProjectBoard_ProjectBoardSeq(user.getUserSeq(), projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Application not found"));

        // Auditable 객체를 통해 삭제일 설정
        applyMember.getAuditable().setDelDate(LocalDateTime.now());

        // 신청 삭제
        projectApplyMemberRepository.delete(applyMember);
    }
}
