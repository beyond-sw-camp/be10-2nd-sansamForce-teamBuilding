package sansam.team.project.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.project.command.application.dto.board.ProjectBoardDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;
import sansam.team.project.command.application.service.ProjectBoardService;

@RestController
@RequestMapping("api/v1/admin/project/board")
@RequiredArgsConstructor
@Tag(name = "Project Board API", description = "프로젝트 게시물 API")
public class ProjectBoardController {

    private final ProjectBoardService projectBoardService;

    @PostMapping
    @Operation(summary = "프로젝트 게시물 추가", description = "프로젝트 게시물 추가 API (관리자만 가능)")
    public ResponseEntity<ProjectBoard> createProjectBoard(
            @RequestBody ProjectBoardDTO projectBoardDTO) {
        // 서비스로 전달하여 ProjectBoard 생성
        ProjectBoard projectBoard = projectBoardService.createProjectBoard(projectBoardDTO);
        return ResponseEntity.ok(projectBoard);
    }

   /* @PutMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 게시물 수정", description = "프로젝트 게시물 수정 API (관리자만 가능)")
    public ResponseEntity<ProjectBoard> updateProjectBoard(
            @PathVariable Long projectBoardSeq,
            @RequestBody ProjectBoardDTO projectBoardDTO) {
        ProjectBoard updatedProjectBoard = projectBoardService.updateProjectBoard(projectBoardSeq, projectBoardDTO);
        return ResponseEntity.ok(updatedProjectBoard);
    }

    @DeleteMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 게시물 삭제", description = "프로젝트 게시물 삭제 API (관리자만 가능), 테스트 용도 삭제 API")
    public ResponseEntity<Void> deleteProjectBoard(@PathVariable Long projectBoardSeq) {
        projectBoardService.deleteProjectBoard(projectBoardSeq);
        return ResponseEntity.noContent().build();
    }

    // 신청 회원의 상태 업데이트 API
    @PutMapping("/{projectBoardSeq}/apply-member/{applyMemberSeq}")
    @Operation(summary = "프로젝트 게시물 신청 회원 상태 수정", description = "관리자가 해당 게시물에 신청한 회원의 상태를 조정하는 API")
    public ResponseEntity<Void> updateApplyMemberStatus(
            @PathVariable Long projectBoardSeq,
            @PathVariable Long applyMemberSeq,
            @RequestBody ProjectApplyMemberDTO projectApplyMemberDTO) {
        // 서비스로 상태 업데이트 요청
        projectBoardService.updateApplyMemberStatus(projectBoardSeq, applyMemberSeq, projectApplyMemberDTO);
        return ResponseEntity.noContent().build();
    }*/
}
