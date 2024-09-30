package sansam.team.project.query.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sansam.team.project.command.domain.aggregate.ApplyStatus;
import sansam.team.project.query.dto.ProjectApplyMemberQueryDTO;
import sansam.team.project.query.dto.AdminProjectBoardDTO;
import sansam.team.project.query.dto.ProjectBoardAllQueryDTO;
import sansam.team.project.query.dto.ProjectBoardDTO;
import sansam.team.project.query.mapper.ProjectBoardMapper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectBoardQueryServiceTest {

    @Mock
    private ProjectBoardMapper projectBoardMapper;

    @InjectMocks
    private ProjectBoardQueryService projectBoardQueryService;

    @Test
    void getAllProjectBoards_ShouldReturnAllProjectBoards() {
        // Given
        List<ProjectBoardAllQueryDTO> expected = Arrays.asList(
                new ProjectBoardAllQueryDTO(
                        1L,
                        "Project 1",
                        "Description 1",
                        5,
                        "https://example.com/image1.jpg",
                        LocalDateTime.of(2023, 10, 1, 0, 0),
                        LocalDateTime.of(2023, 12, 31, 0, 0),
                        "ONGOING"
                ),
                new ProjectBoardAllQueryDTO(
                        2L,
                        "Project 2",
                        "Description 2",
                        3,
                        "https://example.com/image2.jpg",
                        LocalDateTime.of(2023, 11, 1, 0, 0),
                        LocalDateTime.of(2024, 1, 31, 0, 0),
                        "COMPLETED"
                )
        );
        when(projectBoardMapper.findAll()).thenReturn(expected);

        // When
        List<ProjectBoardAllQueryDTO> actual = projectBoardQueryService.getAllProjectBoards();

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void getProjectBoardByIdForAdmin_ShouldReturnProjectBoardForAdmin() {
        // Given
        Long projectBoardSeq = 1L;
        AdminProjectBoardDTO expected = new AdminProjectBoardDTO(
                projectBoardSeq,
                1L,
                "Project 1",
                "Description 1",
                5,
                "https://example.com/image1.jpg",
                LocalDateTime.of(2023, 10, 1, 0, 0),
                LocalDateTime.of(2023, 12, 31, 0, 0),
                "ONGOING",
                LocalDateTime.of(2023, 10, 5, 0, 0),
                LocalDateTime.of(2023, 12, 25, 0, 0),
                LocalDateTime.of(2023, 9, 1, 0, 0),
                LocalDateTime.of(2023, 9, 10, 0, 0),
                null
        );
        when(projectBoardMapper.findByIdForAdmin(projectBoardSeq)).thenReturn(expected);

        // When
        AdminProjectBoardDTO actual = projectBoardQueryService.getProjectBoardByIdForAdmin(projectBoardSeq);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void getProjectBoardByIdForUser_ShouldReturnProjectBoardForUser() {
        // Given
        Long projectBoardSeq = 1L;
        ProjectBoardDTO expected = new ProjectBoardDTO(
                projectBoardSeq,
                "Project 1",
                "Description 1",
                5,
                "https://example.com/image1.jpg",
                "ONGOING",
                LocalDateTime.of(2023, 10, 1, 0, 0),
                LocalDateTime.of(2023, 12, 31, 0, 0)
        );
        when(projectBoardMapper.findByIdForUser(projectBoardSeq)).thenReturn(expected);

        // When
        ProjectBoardDTO actual = projectBoardQueryService.getProjectBoardByIdForUser(projectBoardSeq);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void findApplyMembersByProjectBoardSeq_ShouldReturnApplyMembersList() {
        // Given
        Long projectBoardSeq = 1L;
        List<ProjectApplyMemberQueryDTO> expected = Arrays.asList(
                new ProjectApplyMemberQueryDTO(
                        1L,
                        "User 1",
                        "Nickname 1",
                        ApplyStatus.APPLIED
                ),
                new ProjectApplyMemberQueryDTO(
                        2L,
                        "User 2",
                        "Nickname 2",
                        ApplyStatus.APPROVED
                )
        );
        when(projectBoardMapper.findApplyMembersByProjectBoardSeq(projectBoardSeq)).thenReturn(expected);

        // When
        List<ProjectApplyMemberQueryDTO> actual = projectBoardQueryService.findApplyMembersByProjectBoardSeq(projectBoardSeq);

        // Then
        assertEquals(expected, actual);
    }
}
