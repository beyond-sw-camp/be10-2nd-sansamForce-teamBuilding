package sansam.team.project.command.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Auditable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import sansam.team.project.command.dto.projectboard.ProjectApplyMemberDTO;
import sansam.team.project.command.dto.projectboard.ProjectBoardDTO;
import sansam.team.project.command.entity.ProjectApplyMember;
import sansam.team.project.command.entity.ProjectBoard;
import sansam.team.project.command.enums.ApplyStatus;
import sansam.team.project.command.enums.BoardStatus;
import sansam.team.project.command.repository.ProjectApplyMemberRepository;
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
    private ProjectApplyMemberRepository projectApplyMemberRepository;

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
                projectBoardDTO.getProjectBoardTitle(),  // projectBoardTitle
                projectBoardDTO.getProjectBoardContent(),  // projectBoardContent
                projectBoardDTO.getProjectBoardHeadCount(),  // projectBoardHeadCount
                projectBoardDTO.getProjectBoardImgUrl(),  // projectBoardImgUrl
                projectBoardDTO.getProjectBoardStartDate(),  // projectBoardStartDate
                projectBoardDTO.getProjectBoardEndDate(),  // projectBoardEndDate
                projectBoardDTO.getBoardStatus(),  // boardStatus
                projectBoardDTO.getProjectStartDate(),  // projectStartDate
                projectBoardDTO.getProjectEndDate(),  // projectEndDate
                mockUser.getUserSeq()
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

    /*@Test
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

    @Test
    void testUpdateApplyMemberStatusSuccess() {
        // Arrange
        Long projectBoardSeq = 1L;
        Long applyMemberSeq = 1L;

        ProjectBoard mockProjectBoard = new ProjectBoard(
                projectBoardSeq,
                "Project Title",
                "Project Content",
                5,
                "imgUrl",
                null,
                null,
                null,
                new Auditable(),
                null,
                null,
                mockUser,
                null
        );

        ProjectApplyMember mockApplyMember = new ProjectApplyMember(
                applyMemberSeq,
                ApplyStatus.APPLIED,
                mockUser,
                mockProjectBoard,
                new Auditable()
        );

        ProjectApplyMemberDTO projectApplyMemberDTO = new ProjectApplyMemberDTO(ApplyStatus.APPROVED); // Update 상태

        when(projectApplyMemberRepository.findById(applyMemberSeq)).thenReturn(Optional.of(mockApplyMember));

        // ApplyStatus 변경 시 새로운 인스턴스를 반환하도록 수정
        ProjectApplyMember updatedApplyMember = new ProjectApplyMember(
                applyMemberSeq,
                projectApplyMemberDTO.getApplyStatus(),
                mockUser,
                mockProjectBoard,
                new Auditable()
        );

        when(projectApplyMemberRepository.save(any(ProjectApplyMember.class))).thenReturn(updatedApplyMember);

        // Act
        projectBoardService.updateApplyMemberStatus(projectBoardSeq, applyMemberSeq, projectApplyMemberDTO);

        // Assert
        verify(projectApplyMemberRepository, times(1)).findById(applyMemberSeq);
        verify(projectApplyMemberRepository, times(1)).save(any(ProjectApplyMember.class));
        assertEquals(ApplyStatus.APPROVED, updatedApplyMember.getProjectApplyMemberStatus());  // 업데이트된 객체에서 상태 확인
    }


    @Test
    void testUpdateApplyMemberStatusNotFound() {
        // Arrange
        Long applyMemberSeq = 1L;
        ProjectApplyMemberDTO projectApplyMemberDTO = new ProjectApplyMemberDTO(ApplyStatus.APPROVED); // Update 상태

        when(projectApplyMemberRepository.findById(applyMemberSeq)).thenReturn(Optional.empty());

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> projectBoardService.updateApplyMemberStatus(1L, applyMemberSeq, projectApplyMemberDTO));
        assertEquals("Apply member not found", exception.getMessage());
    }

    @Test
    void testUpdateApplyMemberStatusProjectMismatch() {
        // Arrange
        Long projectBoardSeq = 1L;
        Long applyMemberSeq = 1L;

        ProjectBoard mockProjectBoard = new ProjectBoard(
                2L, // 다른 ProjectBoardSeq
                "Project Title",
                "Project Content",
                5,
                "imgUrl",
                null,
                null,
                null,
                new Auditable(),
                null,
                null,
                mockUser,
                null
        );

        ProjectApplyMember mockApplyMember = new ProjectApplyMember(
                applyMemberSeq,
                ApplyStatus.APPLIED,
                mockUser,
                mockProjectBoard,
                new Auditable()
        );

        ProjectApplyMemberDTO projectApplyMemberDTO = new ProjectApplyMemberDTO(ApplyStatus.APPROVED); // Update 상태

        when(projectApplyMemberRepository.findById(applyMemberSeq)).thenReturn(Optional.of(mockApplyMember));

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> projectBoardService.updateApplyMemberStatus(projectBoardSeq, applyMemberSeq, projectApplyMemberDTO));
        assertEquals("Apply member does not belong to the specified project", exception.getMessage());
    }*/
}
