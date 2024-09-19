package sansam.team.project.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.project.command.dto.projectboard.ProjectApplyMemberDTO;
import sansam.team.project.command.service.ProjectApplyMemberService;
import sansam.team.project.query.dto.projectboard.ProjectApplyMemberQueryDTO;
import sansam.team.project.query.dto.projectboard.ProjectBoardQueryDTO;
import sansam.team.project.query.service.ProjectBoardQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/project-board")
@RequiredArgsConstructor
@Tag(name = "Project Board API", description = "프로젝트 게시물 API")
public class ProjectBoardQueryController {

    private final ProjectBoardQueryService projectBoardQueryService;


    /* 프로젝트 게시물 전체 조회 */
    @GetMapping
    @Operation(summary = "프로젝트 게시물 전체 조회", description = "프로젝트 게시물 전체 조회 API (관리자만 가능)")
    public ResponseEntity<List<ProjectBoardQueryDTO>> getAllProjectBoards() {
        List<ProjectBoardQueryDTO> projectBoards = projectBoardQueryService.getAllProjectBoards();
        return ResponseEntity.ok(projectBoards);
    }

    /* 프로젝트 게시물 상세 조회*/
    @GetMapping("/{id}")
    @Operation(summary = "프로젝트 게시물 상세 조회", description = "프로젝트 게시물 상세 조회 API (관리자만 가능)")
    public ResponseEntity<ProjectBoardQueryDTO> getProjectBoardById(@PathVariable("id") Long projectBoardSeq) {
        ProjectBoardQueryDTO projectBoard = projectBoardQueryService.getProjectBoardById(projectBoardSeq);
        return ResponseEntity.ok(projectBoard);
    }

    /* 프로젝트 신청 회원 리스트 조회 */
    @GetMapping("/{projectBoardSeq}/apply-members")
    @Operation(summary = "프로젝트 게시물 신청 회원 리스트 조회", description = "프로젝트 게시물 신청 회원 리스트 조회 API (관리자만 가능)")
    public ResponseEntity<List<ProjectApplyMemberQueryDTO>> getApplyMembers(
            @PathVariable Long projectBoardSeq) {
        List<ProjectApplyMemberQueryDTO> applyMembers = projectBoardQueryService.findApplyMembersByProjectBoardSeq(projectBoardSeq);
        return ResponseEntity.ok(applyMembers);
    }
}
