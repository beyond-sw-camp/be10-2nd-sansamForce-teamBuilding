package sansam.team.project.command.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sansam.team.project.command.dto.projectboard.ProjectBoardDTO;
import sansam.team.project.command.entity.ProjectBoard;
import sansam.team.project.command.repository.ProjectBoardRepository;
import sansam.team.user.command.entity.User;
import sansam.team.user.command.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ProjectBoardService {

    private final ProjectBoardRepository projectBoardRepository;
    private final UserRepository userRepository;

    /* 프로젝트 모집글 생성 로직 */
    @Transactional
    public ProjectBoard createProjectBoard(ProjectBoardDTO projectBoardDTO) {
        // SecurityContext에서 현재 인증된 사용자(User 객체) 추출
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();  // User 객체를 추출

        // 추출한 User의 userSeq가 null이 아닌지 확인
        if (user.getUserSeq() == null) {
            throw new IllegalArgumentException("User Seq is null");
        }

        // ProjectBoard 생성
        ProjectBoard projectBoard = new ProjectBoard(
                null,
                projectBoardDTO.getProjectBoardTitle(),
                projectBoardDTO.getProjectBoardContent(),
                projectBoardDTO.getProjectBoardHeadCount(),
                projectBoardDTO.getProjectBoardImgUrl(),
                projectBoardDTO.getProjectBoardStartDate(),
                projectBoardDTO.getProjectBoardEndDate(),
                projectBoardDTO.getBoardStatus(),
                null, // Auditable 자동 처리
                projectBoardDTO.getProjectStartDate(),
                projectBoardDTO.getProjectEndDate(),
                user,  // 올바르게 추출된 User 사용
                null  // projectApplyMembers는 null로 설정 (필요에 따라 빈 리스트로도 가능)
        );

        return projectBoardRepository.save(projectBoard);
    }

    /* 프로젝트 모집글 수정 로직 */
    @Transactional
    public ProjectBoard updateProjectBoard(Long projectBoardSeq, ProjectBoardDTO projectBoardDTO) {
        // 기존 프로젝트 보드를 찾음
        ProjectBoard projectBoard = projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));

        // DTO의 값으로 기존 프로젝트 보드의 필드들을 업데이트
        ProjectBoard updatedProjectBoard = new ProjectBoard(
                projectBoard.getProjectBoardSeq(),
                projectBoardDTO.getProjectBoardTitle(),
                projectBoardDTO.getProjectBoardContent(),
                projectBoardDTO.getProjectBoardHeadCount(),
                projectBoardDTO.getProjectBoardImgUrl(),
                projectBoardDTO.getProjectBoardStartDate(),
                projectBoardDTO.getProjectBoardEndDate(),
                projectBoardDTO.getBoardStatus(),
                projectBoard.getAuditable(),  // Auditable 필드는 유지
                projectBoardDTO.getProjectStartDate(),
                projectBoardDTO.getProjectEndDate(),
                projectBoard.getUser(),  // 기존 User 유지
                projectBoard.getProjectApplyMembers()  // 기존 ApplyMembers 유지
        );

        // 업데이트된 객체 저장 및 반환
        return projectBoardRepository.save(updatedProjectBoard);
    }

    @Transactional
    public void deleteProjectBoard(Long projectBoardSeq) {
        projectBoardRepository.deleteById(projectBoardSeq);
    }
}
