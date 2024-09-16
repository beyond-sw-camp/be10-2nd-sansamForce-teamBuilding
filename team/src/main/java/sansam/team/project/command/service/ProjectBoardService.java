package sansam.team.project.command.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.command.dto.ProjectBoardDTO;
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
        User user = userRepository.findById(projectBoardDTO.getUserSeq())
                .orElseThrow(() -> new IllegalArgumentException("유저가 없습니다."));

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
                user
        );

        return projectBoardRepository.save(projectBoard);
    }

    /* 프로젝트 모집글 생성 로직 */
    @Transactional
    public ProjectBoard updateProjectBoard(Long projectBoardSeq, ProjectBoardDTO projectBoardDTO) {
        ProjectBoard projectBoard = projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));

        projectBoard = new ProjectBoard(
                projectBoardSeq,
                projectBoardDTO.getProjectBoardTitle(),
                projectBoardDTO.getProjectBoardContent(),
                projectBoardDTO.getProjectBoardHeadCount(),
                projectBoardDTO.getProjectBoardImgUrl(),
                projectBoardDTO.getProjectBoardStartDate(),
                projectBoardDTO.getProjectBoardEndDate(),
                projectBoardDTO.getBoardStatus(),
                projectBoard.getAuditable(),  // Auditable 그대로 유지
                projectBoardDTO.getProjectStartDate(),
                projectBoardDTO.getProjectEndDate(),
                projectBoard.getUser() // 기존 유저 그대로 유지
        );

        return projectBoardRepository.save(projectBoard);
    }

    @Transactional
    public void deleteProjectBoard(Long projectBoardSeq) {
        projectBoardRepository.deleteById(projectBoardSeq);
    }
}
