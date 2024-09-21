/*
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
import sansam.team.project.command.entity.ProjectApplyMember;
import sansam.team.project.command.entity.ProjectBoard;
import sansam.team.project.command.domain.aggregate.ApplyStatus;
import sansam.team.project.command.repository.ProjectApplyMemberRepository;
import sansam.team.project.command.repository.ProjectBoardRepository;
import sansam.team.user.command.entity.User;
import sansam.team.user.command.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProjectApplyMemberServiceTest {

    @InjectMocks
    private ProjectApplyMemberService projectApplyMemberService;

    @Mock
    private ProjectApplyMemberRepository projectApplyMemberRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProjectBoardRepository projectBoardRepository;

    @Mock
    private Authentication authentication;

    @Mock
    private SecurityContext securityContext;

    private User mockUser;
    private ProjectBoard mockProjectBoard;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // 필요한 필드만 초기화
        mockUser = User.builder()
                .userSeq(1L)
                .id("testuser")
                .name("Test User")
                .nickname("nickname")
                .password("password")
                .build();

        mockProjectBoard = new ProjectBoard(1L, "Project Title", "Content", 5, null, LocalDateTime.now(), null, null, null, LocalDateTime.now(), null, mockUser, null);

        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void applyForProject_shouldCreateNewProjectApplyMember() {
        // Given
        Long projectBoardSeq = 1L;

        ProjectApplyMember mockProjectApplyMember = new ProjectApplyMember(
                null,
                ApplyStatus.APPLIED,  // 상태를 직접 설정
                mockUser,
                mockProjectBoard,
                new Auditable()
        );

        when(authentication.getPrincipal()).thenReturn(mockUser);
        when(projectBoardRepository.findById(anyLong())).thenReturn(Optional.of(mockProjectBoard));
        when(projectApplyMemberRepository.save(any(ProjectApplyMember.class))).thenReturn(new ProjectApplyMember()); // Save 호출 시 반환될 객체 설정

        // When
        ProjectApplyMember result = projectApplyMemberService.applyForProject(projectBoardSeq);

        // Then
        assertNotNull(result);  // 반환된 객체가 null이 아닌지 확인
        verify(projectApplyMemberRepository, times(1)).save(any(ProjectApplyMember.class));
    }

    @Test
    void cancelApplication_shouldDeleteProjectApplyMember() {
        // Given
        ProjectApplyMember applyMember = new ProjectApplyMember(1L, ApplyStatus.APPLIED, mockUser, mockProjectBoard, new Auditable());  // Auditable 자동 초기화
        Long projectBoardSeq = 1L;  // ProjectBoardSeq 설정

        // SecurityContext에서 User 객체를 반환하도록 설정
        when(authentication.getPrincipal()).thenReturn(mockUser);
        when(projectBoardRepository.findById(anyLong())).thenReturn(Optional.of(mockProjectBoard));
        when(projectApplyMemberRepository.findByUser_UserSeqAndProjectBoard_ProjectBoardSeq(anyLong(), anyLong())).thenReturn(Optional.of(applyMember));

        // When
        projectApplyMemberService.cancelApplication(projectBoardSeq);

        // Then
        verify(projectApplyMemberRepository, times(1)).delete(applyMember);
    }

}
*/
