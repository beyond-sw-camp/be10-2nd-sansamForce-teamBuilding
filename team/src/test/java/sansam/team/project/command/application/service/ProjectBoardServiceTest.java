package sansam.team.project.command.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import sansam.team.project.command.application.dto.board.ProjectApplyMemberDTO;
import sansam.team.project.command.application.dto.board.ProjectBoardCreateDTO;
import sansam.team.project.command.application.dto.board.ProjectBoardUpdateDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;
import sansam.team.project.command.domain.repository.ProjectApplyMemberRepository;
import sansam.team.project.command.domain.repository.ProjectBoardRepository;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.command.infrastructure.repository.JpaUserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProjectBoardServiceTest {

    @Mock
    private ProjectBoardRepository projectBoardRepository;

    @Mock
    private ProjectApplyMemberRepository projectApplyMemberRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private JpaUserRepository userRepository;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private ProjectBoardService projectBoardService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setUserSeq(1L);

        // SecurityContext와 Authentication 설정
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        when(authentication.getPrincipal()).thenReturn(user);
    }

    @Test
    void createProjectBoard_Success() {
        ProjectBoardCreateDTO projectBoardCreateDTO = new ProjectBoardCreateDTO();

        // Mock ProjectBoard 객체 생성
        ProjectBoard projectBoard = mock(ProjectBoard.class);

        // ProjectBoardRepository의 save 메서드가 호출될 때 Mock 객체 반환
        when(projectBoardRepository.save(any(ProjectBoard.class))).thenReturn(projectBoard);

        // ModelMapper의 map 메서드가 호출될 때 Mock 객체 반환
        when(modelMapper.map(any(ProjectBoardCreateDTO.class), eq(ProjectBoard.class))).thenReturn(projectBoard);

        ProjectBoard createdProjectBoard = projectBoardService.createProjectBoard(projectBoardCreateDTO);

        // save 메서드가 호출되었는지 확인
        verify(projectBoardRepository, times(1)).save(any(ProjectBoard.class));
        assertNotNull(createdProjectBoard);
    }

    @Test
    void createProjectBoard_UserSeqIsNull_ThrowsException() {
        // userSeq가 null인 경우를 위해 User 객체 업데이트
        user.setUserSeq(null);

        ProjectBoardCreateDTO projectBoardCreateDTO = new ProjectBoardCreateDTO();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectBoardService.createProjectBoard(projectBoardCreateDTO);
        });

        assertEquals("User Seq is null", exception.getMessage());
    }

    @Test
    void updateProjectBoard_Success() {
        Long projectBoardSeq = 1L;
        ProjectBoardUpdateDTO projectBoardUpdateDTO = new ProjectBoardUpdateDTO();

        // Mock ProjectBoard 객체 생성
        ProjectBoard projectBoard = mock(ProjectBoard.class);

        // ProjectBoardRepository의 findById 메서드가 호출될 때 Mock 객체 반환
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.of(projectBoard));

        // Mock 객체에서 프로젝트 보드 수정 메서드 호출 설정
        doNothing().when(projectBoard).modifyProjectBoard(projectBoardUpdateDTO);

        // updateProjectBoard 메서드 실행
        ProjectBoard updatedProjectBoard = projectBoardService.updateProjectBoard(projectBoardSeq, projectBoardUpdateDTO);

        // findById 메서드가 호출되었는지 확인
        verify(projectBoardRepository, times(1)).findById(projectBoardSeq);

        // modifyProjectBoard 메서드가 호출되었는지 확인
        verify(projectBoard, times(1)).modifyProjectBoard(projectBoardUpdateDTO);

        // 반환된 객체가 Null이 아닌지 확인
        assertNotNull(updatedProjectBoard);
    }

    @Test
    void updateProjectBoard_ProjectBoardNotFound_ThrowsException() {
        Long projectBoardSeq = 1L;
        ProjectBoardUpdateDTO projectBoardUpdateDTO = new ProjectBoardUpdateDTO();

        // Mock ProjectBoardRepository의 findById 메서드가 빈 값을 반환하도록 설정
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectBoardService.updateProjectBoard(projectBoardSeq, projectBoardUpdateDTO);
        });

        assertEquals("Project board not found", exception.getMessage());
    }

    @Test
    void deleteProjectBoard_Success() {
        Long projectBoardSeq = 1L;

        // Mock ProjectBoardRepository의 deleteById 메서드 호출
        doNothing().when(projectBoardRepository).deleteById(projectBoardSeq);

        projectBoardService.deleteProjectBoard(projectBoardSeq);

        // deleteById 메서드가 호출되었는지 확인
        verify(projectBoardRepository, times(1)).deleteById(projectBoardSeq);
    }

    @Test
    void updateApplyMemberStatus_Success() {
        // Given
        Long projectBoardSeq = 1L;
        Long applyMemberSeq = 1L;
        ProjectApplyMemberDTO projectApplyMemberDTO = new ProjectApplyMemberDTO();

        // Mock ProjectApplyMember 객체 생성
        ProjectApplyMember applyMember = mock(ProjectApplyMember.class);

        // Mock ProjectBoard 객체 생성
        ProjectBoard projectBoard = mock(ProjectBoard.class);

        // ProjectApplyMemberRepository가 applyMember를 반환하도록 Mock 설정
        when(projectApplyMemberRepository.findById(applyMemberSeq)).thenReturn(Optional.of(applyMember));

        // ProjectBoardRepository가 projectBoard를 반환하도록 Mock 설정
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.of(projectBoard));

        // applyMember 객체의 modifyApplyMemberStatus 메서드 호출 설정
        doNothing().when(applyMember).modifyApplyMemberStatus(anyLong(), any(ProjectApplyMemberDTO.class));

        // When
        ProjectApplyMember result = projectBoardService.updateApplyMemberStatus(projectBoardSeq, applyMemberSeq, projectApplyMemberDTO);

        // Then
        assertNotNull(result); // 결과가 null이 아닌지 확인
        verify(applyMember, times(1)).modifyApplyMemberStatus(projectBoard.getProjectBoardSeq(), projectApplyMemberDTO);
    }

    @Test
    void updateApplyMemberStatus_ApplyMemberNotFound_ThrowsException() {
        // Given
        Long projectBoardSeq = 1L;
        Long applyMemberSeq = 1L;
        ProjectApplyMemberDTO projectApplyMemberDTO = new ProjectApplyMemberDTO();

        // ProjectApplyMemberRepository가 빈 값을 반환하도록 설정
        when(projectApplyMemberRepository.findById(applyMemberSeq)).thenReturn(Optional.empty());

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectBoardService.updateApplyMemberStatus(projectBoardSeq, applyMemberSeq, projectApplyMemberDTO);
        });

        assertEquals("Apply member not found", exception.getMessage());
    }

    @Test
    void updateApplyMemberStatus_ProjectBoardNotFound_ThrowsException() {
        // Given
        Long projectBoardSeq = 1L;
        Long applyMemberSeq = 1L;
        ProjectApplyMemberDTO projectApplyMemberDTO = new ProjectApplyMemberDTO();

        // ProjectApplyMember 객체를 반환하도록 Mock 설정
        ProjectApplyMember applyMember = mock(ProjectApplyMember.class);
        when(projectApplyMemberRepository.findById(applyMemberSeq)).thenReturn(Optional.of(applyMember));

        // ProjectBoardRepository가 빈 값을 반환하도록 설정
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.empty());

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectBoardService.updateApplyMemberStatus(projectBoardSeq, applyMemberSeq, projectApplyMemberDTO);
        });

        assertEquals("Project board not found", exception.getMessage());
    }
}
