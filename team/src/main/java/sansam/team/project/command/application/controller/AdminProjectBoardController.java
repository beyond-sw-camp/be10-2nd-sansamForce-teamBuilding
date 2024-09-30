package sansam.team.project.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.project.command.application.dto.AdminProjectApplyMemberDTO;
import sansam.team.project.command.application.dto.AdminProjectBoardCreateDTO;
import sansam.team.project.command.application.dto.AdminProjectBoardUpdateDTO;
import sansam.team.project.command.application.service.AdminProjectBoardService;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;

@RestController
@RequestMapping("api/v1/admin/project/board")
@RequiredArgsConstructor
@Tag(name = "2-1. Project Board Admin API", description = "프로젝트 게시물 관리자 API")
public class AdminProjectBoardController {

    private final AdminProjectBoardService adminProjectBoardService;

    @PostMapping
    @Operation(summary = "프로젝트 게시물 추가", description = "프로젝트 게시물 추가 API (관리자만 가능)")
    public ResponseEntity<ProjectBoard> createProjectBoard(
            @RequestBody AdminProjectBoardCreateDTO adminProjectBoardCreateDTO) { // UserPrincipal을 주입받음

        // 서비스로 전달하여 ProjectBoard 생성
        ProjectBoard projectBoard = adminProjectBoardService.createProjectBoard(adminProjectBoardCreateDTO);

        return ResponseEntity.ok(projectBoard);
    }

    @PutMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 게시물 수정", description = "프로젝트 게시물 수정 API (관리자만 가능)")
    public ResponseEntity<ProjectBoard> updateProjectBoard(
            @PathVariable Long projectBoardSeq,
            @RequestBody AdminProjectBoardUpdateDTO adminProjectBoardUpdateDTO) {
        // 프로젝트 게시물 업데이트 요청
        ProjectBoard updatedProjectBoard = adminProjectBoardService.updateProjectBoard(projectBoardSeq, adminProjectBoardUpdateDTO);
        return ResponseEntity.ok(updatedProjectBoard);
    }

    @DeleteMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 게시물 삭제", description = "프로젝트 게시물 삭제 API (관리자만 가능), 테스트 용도 삭제 API")
    public ResponseEntity<Void> deleteProjectBoard(@PathVariable Long projectBoardSeq) {
        adminProjectBoardService.deleteProjectBoard(projectBoardSeq);
        return ResponseEntity.noContent().build();
    }

    // 신청 회원의 상태 업데이트 API
    @PutMapping("/{projectBoardSeq}/apply-member/{applyMemberSeq}")
    @Operation(summary = "프로젝트 게시물 신청 회원 상태 수정", description = "관리자가 해당 게시물에 신청한 회원의 상태를 조정하는 API")
    public ResponseEntity<ProjectApplyMember> updateApplyMemberStatus(
            @PathVariable Long projectBoardSeq,
            @PathVariable Long applyMemberSeq,
            @RequestBody AdminProjectApplyMemberDTO adminProjectApplyMemberDTO) {
        // 서비스로 상태 업데이트 요청
        ProjectApplyMember updatedApplyMember = adminProjectBoardService.updateApplyMemberStatus(projectBoardSeq, applyMemberSeq, adminProjectApplyMemberDTO);
        return ResponseEntity.ok(updatedApplyMember);
    }
}
