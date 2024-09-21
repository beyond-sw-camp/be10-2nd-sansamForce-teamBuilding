package sansam.team.project.query.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import sansam.team.project.query.dto.projectboard.ApplyMemberQueryDTO;
import sansam.team.project.query.mapper.ProjectApplyMemberMapper;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.project.command.domain.aggregate.ApplyStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProjectApplyMemberServiceTest {

    @InjectMocks
    private ProjectApplyMemberQueryService projectApplyMemberQueryService;

    @Mock
    private ProjectApplyMemberMapper projectApplyMemberMapper;

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
        mockUser.setUserSeq(1L);  // userSeq를 설정

        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(mockUser);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void testFindProjectsByCurrentUserSuccess() {
        // Arrange
        Long userSeq = 1L;
        LocalDateTime now = LocalDateTime.now();

        ApplyMemberQueryDTO project1 = new ApplyMemberQueryDTO(
                ApplyStatus.APPLIED,
                "Project Title 1",
                "Project Content 1",
                5,
                "imgUrl1",
                now.minusDays(5),
                now.plusDays(25),
                now.minusDays(1),
                now.plusDays(30)
        );

        ApplyMemberQueryDTO project2 = new ApplyMemberQueryDTO(
                ApplyStatus.APPROVED,
                "Project Title 2",
                "Project Content 2",
                10,
                "imgUrl2",
                now.minusDays(10),
                now.plusDays(20),
                now.minusMonths(1),
                now.plusMonths(1)
        );

        List<ApplyMemberQueryDTO> mockProjects = Arrays.asList(project1, project2);

        when(projectApplyMemberMapper.findProjectsByUserSeq(userSeq)).thenReturn(mockProjects);

        // Act
        List<ApplyMemberQueryDTO> result = projectApplyMemberQueryService.findProjectsByCurrentUser();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Project Title 1", result.get(0).getProjectBoardTitle());
        assertEquals(ApplyStatus.APPLIED, result.get(0).getApplyStatus());
        assertEquals("Project Title 2", result.get(1).getProjectBoardTitle());
        assertEquals(ApplyStatus.APPROVED, result.get(1).getApplyStatus());
        verify(projectApplyMemberMapper, times(1)).findProjectsByUserSeq(userSeq);
    }

    @Test
    void testFindProjectsByCurrentUserNoProjects() {
        // Arrange
        Long userSeq = 1L;

        when(projectApplyMemberMapper.findProjectsByUserSeq(userSeq)).thenReturn(Arrays.asList());

        // Act
        List<ApplyMemberQueryDTO> result = projectApplyMemberQueryService.findProjectsByCurrentUser();

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(projectApplyMemberMapper, times(1)).findProjectsByUserSeq(userSeq);
    }
}
