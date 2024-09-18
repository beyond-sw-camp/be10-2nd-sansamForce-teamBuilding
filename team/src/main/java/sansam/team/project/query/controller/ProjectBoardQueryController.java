package sansam.team.project.query.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.project.query.dto.ProjectBoardQueryDTO;
import sansam.team.project.query.service.ProjectBoardQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/project-board")
@RequiredArgsConstructor
@Tag(name = "Project Board API", description = "프로젝트 게시물 API")
public class ProjectBoardQueryController {

    private final ProjectBoardQueryService projectBoardQueryService;

    @GetMapping
    public ResponseEntity<List<ProjectBoardQueryDTO>> getAllProjectBoards() {
        List<ProjectBoardQueryDTO> projectBoards = projectBoardQueryService.getAllProjectBoards();
        return ResponseEntity.ok(projectBoards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectBoardQueryDTO> getProjectBoardById(@PathVariable("id") Long projectBoardSeq) {
        ProjectBoardQueryDTO projectBoard = projectBoardQueryService.getProjectBoardById(projectBoardSeq);
        return ResponseEntity.ok(projectBoard);
    }
}
