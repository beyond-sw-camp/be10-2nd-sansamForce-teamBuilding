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
import sansam.team.project.command.application.dto.project.ProjectDTO;
import sansam.team.project.command.entity.Project;
import sansam.team.project.command.domain.aggregate.ProjectStatus;
import sansam.team.project.command.repository.ProjectRepository;
import sansam.team.user.command.entity.User;
import sansam.team.user.command.infrastructure.repository.UserRepository;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    private User mockUser;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);

        mockUser = new User();
        mockUser.setUserSeq(1L);

        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(mockUser);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void testCreateProjectSuccess(){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectTitle("Test Project");
        projectDTO.setProjectContent("Test Content");
        projectDTO.setProjectHeadCount(10);
        projectDTO.setProjectImgUrl("imgUrl");
        projectDTO.setProjectStatus(ProjectStatus.PROGRESS);
        projectDTO.setProjectStartDate(LocalDateTime.now());
        projectDTO.setProjectEndDate(LocalDateTime.now().plusDays(30));

        Project mockProject = new Project(
                projectDTO.getProjectTitle(),
                projectDTO.getProjectContent(),
                projectDTO.getProjectStatus(),
                projectDTO.getProjectHeadCount(),
                projectDTO.getProjectImgUrl(),
                projectDTO.getProjectStartDate(),
                projectDTO.getProjectEndDate(),
                mockUser
        );

        when(projectRepository.save(any(Project.class))).thenReturn(mockProject);

        // Act
        Project createdProject = projectService.createProject(projectDTO);

        // Assert
        assertNotNull(createdProject);
        assertEquals("Test Project", createdProject.getProjectTitle());
        assertEquals("Test Content", createdProject.getProjectContent());
        assertEquals(ProjectStatus.PROGRESS, createdProject.getProjectStatus());
        assertEquals("imgUrl", createdProject.getProjectImgUrl());
        verify(projectRepository, times(1)).save(any(Project.class));
        verify(authentication, times(1)).getPrincipal();

    }

    @Test
    void testCreateProjectUserSeqIsNull(){

        mockUser.setUserSeq(null);
        ProjectDTO projectDTO = new ProjectDTO();

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> projectService.createProject(projectDTO));
        assertEquals("User Seq is null", exception.getMessage());
    }
}
*/
