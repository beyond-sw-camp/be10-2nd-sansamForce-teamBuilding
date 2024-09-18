package sansam.team.project.command.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import sansam.team.common.embedded.Auditable;
import sansam.team.project.command.dto.projectboard.ProjectBoardDTO;
import sansam.team.project.command.entity.ProjectBoard;
import sansam.team.project.command.enums.BoardStatus;
import sansam.team.project.command.repository.ProjectBoardRepository;
import sansam.team.user.command.entity.User;
import sansam.team.user.command.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectBoardServiceTest {

    @InjectMocks
    private ProjectBoardService projectBoardService;

    @Mock
    private ProjectBoardRepository projectBoardRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    private User mockUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock SecurityContext and Authentication
        mockUser = new User();
        mockUser.setUserSeq(1L);  // Ensure userSeq is not null

        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(mockUser);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void testCreateProjectBoardSuccess() {
        // Arrange
        ProjectBoardDTO projectBoardDTO = new ProjectBoardDTO();
        projectBoardDTO.setProjectBoardTitle("Test Project");
        projectBoardDTO.setProjectBoardContent("Content");
        projectBoardDTO.setProjectBoardHeadCount(5);
        projectBoardDTO.setProjectBoardImgUrl("imgUrl");
        projectBoardDTO.setProjectBoardStartDate(LocalDateTime.now());
        projectBoardDTO.setBoardStatus(BoardStatus.RECRUITMENT);
        projectBoardDTO.setProjectStartDate(LocalDateTime.now());
        projectBoardDTO.setProjectEndDate(LocalDateTime.now().plusDays(30));

        // Mock the ProjectBoard object with non-nullable fields populated
        ProjectBoard mockProjectBoard = new ProjectBoard(
                null,  // projectBoardSeq
                projectBoardDTO.getProjectBoardTitle(),  // projectBoardTitle
                projectBoardDTO.getProjectBoardContent(),  // projectBoardContent
                projectBoardDTO.getProjectBoardHeadCount(),  // projectBoardHeadCount
                projectBoardDTO.getProjectBoardImgUrl(),  // projectBoardImgUrl
                projectBoardDTO.getProjectBoardStartDate(),  // projectBoardStartDate
                projectBoardDTO.getProjectBoardEndDate(),  // projectBoardEndDate
                projectBoardDTO.getBoardStatus(),  // boardStatus
                new Auditable(),  // auditable
                projectBoardDTO.getProjectStartDate(),  // projectStartDate
                projectBoardDTO.getProjectEndDate(),  // projectEndDate
                mockUser,  // user
                null
        );

        when(projectBoardRepository.save(any(ProjectBoard.class))).thenReturn(mockProjectBoard);

        // Act
        ProjectBoard createdProjectBoard = projectBoardService.createProjectBoard(projectBoardDTO);

        // Assert
        assertNotNull(createdProjectBoard);
        assertEquals("Test Project", createdProjectBoard.getProjectBoardTitle());
        assertEquals("Content", createdProjectBoard.getProjectBoardContent());
        assertEquals(5, createdProjectBoard.getProjectBoardHeadCount());
        verify(projectBoardRepository, times(1)).save(any(ProjectBoard.class));
        verify(authentication, times(1)).getPrincipal();
    }

    @Test
    void testCreateProjectBoardUserSeqIsNull() {
        // Arrange
        mockUser.setUserSeq(null);  // Set userSeq to null
        ProjectBoardDTO projectBoardDTO = new ProjectBoardDTO();

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> projectBoardService.createProjectBoard(projectBoardDTO));
        assertEquals("User Seq is null", exception.getMessage());
    }

    @Test
    void testUpdateProjectBoardSuccess() {
        // Arrange
        Long projectBoardSeq = 1L;
        ProjectBoardDTO projectBoardDTO = new ProjectBoardDTO();
        projectBoardDTO.setProjectBoardTitle("Updated Title");
        projectBoardDTO.setProjectBoardContent("Updated Content");
        projectBoardDTO.setProjectBoardHeadCount(10);
        projectBoardDTO.setProjectBoardImgUrl("updatedImgUrl");
        projectBoardDTO.setProjectBoardStartDate(LocalDateTime.now());
        projectBoardDTO.setProjectBoardEndDate(LocalDateTime.now().plusDays(30));
        projectBoardDTO.setBoardStatus(BoardStatus.RECRUITMENT);
        projectBoardDTO.setProjectStartDate(LocalDateTime.now());
        projectBoardDTO.setProjectEndDate(LocalDateTime.now().plusMonths(1));

        // 기존 프로젝트 보드를 생성
        ProjectBoard existingProjectBoard = new ProjectBoard(
                projectBoardSeq,  // projectBoardSeq
                "Old Title",  // 기존 타이틀
                "Old Content",  // 기존 내용
                5,  // 기존 headCount
                "oldImgUrl",  // 기존 이미지 URL
                LocalDateTime.now(),  // 기존 모집 시작 날짜
                LocalDateTime.now().plusDays(30),  // 기존 모집 종료 날짜
                BoardStatus.RECRUITMENT,  // 기존 상태
                new Auditable(),  // Auditable 필드
                LocalDateTime.now(),  // 프로젝트 시작 날짜
                LocalDateTime.now().plusMonths(1),  // 프로젝트 종료 날짜
                mockUser,  // User
                null
        );

        // 기존 ProjectBoard를 찾도록 Mocking
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.of(existingProjectBoard));

        // 저장될 때 업데이트된 ProjectBoard 반환
        ProjectBoard updatedProjectBoard = new ProjectBoard(
                projectBoardSeq,
                projectBoardDTO.getProjectBoardTitle(),
                projectBoardDTO.getProjectBoardContent(),
                projectBoardDTO.getProjectBoardHeadCount(),
                projectBoardDTO.getProjectBoardImgUrl(),
                projectBoardDTO.getProjectBoardStartDate(),
                projectBoardDTO.getProjectBoardEndDate(),
                projectBoardDTO.getBoardStatus(),
                new Auditable(),
                projectBoardDTO.getProjectStartDate(),
                projectBoardDTO.getProjectEndDate(),
                mockUser,
                null
        );

        when(projectBoardRepository.save(any(ProjectBoard.class))).thenReturn(updatedProjectBoard);

        // Act
        ProjectBoard result = projectBoardService.updateProjectBoard(projectBoardSeq, projectBoardDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Updated Title", result.getProjectBoardTitle());
        assertEquals("Updated Content", result.getProjectBoardContent());
        assertEquals(10, result.getProjectBoardHeadCount());
        assertEquals("updatedImgUrl", result.getProjectBoardImgUrl());
        assertEquals(BoardStatus.RECRUITMENT, result.getBoardStatus());
        verify(projectBoardRepository, times(1)).findById(projectBoardSeq);
        verify(projectBoardRepository, times(1)).save(any(ProjectBoard.class));
    }

    @Test
    void testUpdateProjectBoardNotFound() {
        // Arrange
        Long projectBoardSeq = 1L;
        ProjectBoardDTO projectBoardDTO = new ProjectBoardDTO();

        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.empty());

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> projectBoardService.updateProjectBoard(projectBoardSeq, projectBoardDTO));
        assertEquals("Project board not found", exception.getMessage());
    }

    @Test
    void testDeleteProjectBoardSuccess() {
        // Arrange
        Long projectBoardSeq = 1L;

        // Act
        projectBoardService.deleteProjectBoard(projectBoardSeq);

        // Assert
        verify(projectBoardRepository, times(1)).deleteById(projectBoardSeq);
    }
}
