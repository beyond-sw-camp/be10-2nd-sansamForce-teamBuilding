package sansam.team.project.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;
import sansam.team.project.command.domain.aggregate.ApplyStatus;
import sansam.team.project.command.infrastructure.repository.JpaProjectApplyMemberRepository;
import sansam.team.project.command.infrastructure.repository.JpaProjectBoardRepository;
import sansam.team.user.command.entity.User;

@Service
@RequiredArgsConstructor
public class ProjectApplyMemberService {

    private final JpaProjectApplyMemberRepository jpaProjectApplyMemberRepository;
    private final JpaProjectBoardRepository jpaProjectBoardRepository;

    // 인증된 사용자(User)를 가져오는 메서드
    private User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    // ProjectBoard를 조회하는 메서드
    private ProjectBoard getProjectBoard(Long projectBoardSeq) {
        return jpaProjectBoardRepository.findById(projectBoardSeq)
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
                ApplyStatus.APPLIED,
                user,
                projectBoard
        );

        return jpaProjectApplyMemberRepository.save(projectApplyMember);
    }

    @Transactional
    public void cancelApplication(Long projectBoardSeq) {

        // 인증된 사용자 추출
        User user = getAuthenticatedUser();

        // ProjectBoardSeq로 ProjectBoard 엔티티 조회
        ProjectBoard projectBoard = getProjectBoard(projectBoardSeq);

        // userSeq와 projectBoard로 ProjectApplyMember 조회
        ProjectApplyMember applyMember = jpaProjectApplyMemberRepository.findByUser_UserSeqAndProjectBoard_ProjectBoardSeq(user.getUserSeq(), projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Application not found"));

        // 신청 삭제
        jpaProjectApplyMemberRepository.delete(applyMember);
    }
}
