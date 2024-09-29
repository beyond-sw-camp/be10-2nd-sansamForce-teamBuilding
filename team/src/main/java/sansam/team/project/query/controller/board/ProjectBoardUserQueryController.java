package sansam.team.project.query.controller.board;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.project.query.dto.projectboard.ProjectBoardAllQueryDTO;
import sansam.team.project.query.dto.projectboard.ProjectBoardUserDTO;
import sansam.team.project.query.service.ProjectBoardQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project/board")
@RequiredArgsConstructor
@Tag(name = "Project Board User API", description = "프로젝트 게시물 유저 API")
public class ProjectBoardUserQueryController {

    private final ProjectBoardQueryService projectBoardQueryService;

    /* 프로젝트 게시물 전체 조회 */
    @GetMapping
    @Operation(summary = "프로젝트 게시물 전체 조회", description = "프로젝트 게시물 전체 조회 API (사용자가 조회)")
    public List<ProjectBoardAllQueryDTO> getAllProjectBoards() {
        return projectBoardQueryService.getAllProjectBoards(); // ResponseEntity 생략하고 DTO 반환
    }

    /* 프로젝트 게시물 상세 조회 */
    @GetMapping("/{id}")
    @Operation(summary = "프로젝트 게시물 상세 조회", description = "프로젝트 게시물 상세 조회 API (사용자가 조회)")
    public ProjectBoardUserDTO getProjectBoardById(@PathVariable("id") Long projectBoardSeq) {
        return projectBoardQueryService.getProjectBoardByIdForUser(projectBoardSeq); // ResponseEntity 생략하고 DTO 반환
    }
}
