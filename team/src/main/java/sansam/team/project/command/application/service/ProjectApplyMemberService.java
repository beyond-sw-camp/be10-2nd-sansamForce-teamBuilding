package sansam.team.project.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.project.command.application.dto.board.ProjectApplyMemberDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;
import sansam.team.project.command.domain.repository.ProjectApplyMemberRepository;
import sansam.team.project.command.domain.repository.ProjectBoardRepository;
import sansam.team.project.command.mapper.ProjectApplyMemberMapper;
import sansam.team.user.command.entity.User;

@Service
@RequiredArgsConstructor
public class ProjectApplyMemberService {

    private final ProjectApplyMemberRepository projectApplyMemberRepository;
    private final ProjectBoardRepository projectBoardRepository;


    @Transactional
    public ProjectApplyMember applyForProject(Long projectBoardSeq, ProjectApplyMemberDTO applyMemberDTO) {

        // SecurityContext에서 현재 인증된 사용자(User 객체) 추출
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        // 추출한 User의 userSeq가 null이 아닌지 확인
        if (user.getUserSeq() == null) {
            throw new IllegalArgumentException("User Seq is null");
        }

        ProjectBoard projectBoard = projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));

        ProjectApplyMember projectApplyMember = ProjectApplyMemberMapper.toEntity(user.getUserSeq(), projectBoard.getProjectBoardSeq(), applyMemberDTO);

        projectApplyMemberRepository.save(projectApplyMember);

        return projectApplyMember;
    }

    @Transactional
    public void cancelApplication(Long projectBoardSeq) {

        // SecurityContext에서 현재 인증된 사용자(User 객체) 추출
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

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
