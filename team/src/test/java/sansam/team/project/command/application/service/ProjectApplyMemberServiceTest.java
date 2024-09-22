package sansam.team.project.command.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import sansam.team.project.command.application.dto.board.ProjectApplyMemberDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;
import sansam.team.project.command.domain.repository.ProjectApplyMemberRepository;
import sansam.team.project.command.domain.repository.ProjectBoardRepository;
import sansam.team.user.command.domain.aggregate.entity.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProjectApplyMemberServiceTest {

    @Mock
    private ProjectApplyMemberRepository projectApplyMemberRepository;

    @Mock
    private ProjectBoardRepository projectBoardRepository;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private ProjectApplyMemberService projectApplyMemberService;

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
    public void testApplyForProject_Success_WithMock() {
        // Given
        Long projectBoardSeq = 1L; // 임의의 프로젝트 보드 ID 설정
        ProjectApplyMemberDTO applyMemberDTO = new ProjectApplyMemberDTO();
        User user = new User();
        user.setUserSeq(1L); // 임의의 사용자 ID 설정

        // ProjectBoard를 mock으로 생성
        ProjectBoard projectBoard = mock(ProjectBoard.class);

        // mock 객체의 동작 설정
        when(projectBoard.getProjectBoardSeq()).thenReturn(projectBoardSeq);

        // SecurityContextHolder에 인증된 사용자 설정
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(user);
        SecurityContextHolder.setContext(securityContext);

        // projectBoardRepository가 프로젝트 보드를 반환하도록 Mock 설정
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.of(projectBoard));

        // projectApplyMemberRepository의 save 메서드를 Mock 설정
        when(projectApplyMemberRepository.save(any(ProjectApplyMember.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // When
        ProjectApplyMember result = projectApplyMemberService.applyForProject(projectBoardSeq, applyMemberDTO);

        // Then
        assertNotNull(result); // 결과가 null이 아닌지 확인
        assertEquals(user.getUserSeq(), result.getUserSeq()); // 사용자 ID가 일치하는지 확인
        assertEquals(projectBoardSeq, result.getProjectBoardSeq()); // 프로젝트 보드 ID가 일치하는지 확인

        // 각 Repository 메서드가 한 번씩 호출되었는지 검증
        verify(projectBoardRepository, times(1)).findById(projectBoardSeq);
        verify(projectApplyMemberRepository, times(1)).save(any(ProjectApplyMember.class));
    }



    @Test
    void applyForProject_UserSeqIsNull_ThrowsException() {
        // userSeq가 null인 경우를 위해 User 객체 업데이트
        user.setUserSeq(null);

        Long projectBoardSeq = 1L;
        ProjectApplyMemberDTO applyMemberDTO = new ProjectApplyMemberDTO();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectApplyMemberService.applyForProject(projectBoardSeq, applyMemberDTO);
        });

        assertEquals("User Seq is null", exception.getMessage());
    }

    @Test
    void applyForProject_ProjectBoardNotFound_ThrowsException() {
        Long projectBoardSeq = 1L;
        ProjectApplyMemberDTO applyMemberDTO = new ProjectApplyMemberDTO();

        // ProjectBoardRepository의 findById 메서드가 빈 값을 반환하도록 설정
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectApplyMemberService.applyForProject(projectBoardSeq, applyMemberDTO);
        });

        assertEquals("Project board not found", exception.getMessage());
    }

    @Test
    void cancelApplication_Success() {
        Long projectBoardSeq = 1L;
        ProjectBoard projectBoard = mock(ProjectBoard.class);

        // ProjectBoardRepository의 findById 메서드가 호출될 때 Mock 객체 반환
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.of(projectBoard));

        // ProjectApplyMemberRepository의 deleteById 메서드가 호출될 때 아무 동작도 하지 않도록 설정
        doNothing().when(projectApplyMemberRepository).deleteById(projectBoardSeq);

        projectApplyMemberService.cancelApplication(projectBoardSeq);

        // findById 및 deleteById 메서드가 호출되었는지 확인
        verify(projectBoardRepository, times(1)).findById(projectBoardSeq);
        verify(projectApplyMemberRepository, times(1)).deleteById(projectBoardSeq);
    }

    @Test
    void cancelApplication_UserSeqIsNull_ThrowsException() {
        // userSeq가 null인 경우를 위해 User 객체 업데이트
        user.setUserSeq(null);

        Long projectBoardSeq = 1L;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectApplyMemberService.cancelApplication(projectBoardSeq);
        });

        assertEquals("User Seq is null", exception.getMessage());
    }

    @Test
    void cancelApplication_ProjectBoardNotFound_ThrowsException() {
        Long projectBoardSeq = 1L;

        // ProjectBoardRepository의 findById 메서드가 빈 값을 반환하도록 설정
        when(projectBoardRepository.findById(projectBoardSeq)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projectApplyMemberService.cancelApplication(projectBoardSeq);
        });

        assertEquals("Project board not found", exception.getMessage());
    }
}
