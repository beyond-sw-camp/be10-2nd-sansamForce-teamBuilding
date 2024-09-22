package sansam.team.project.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.project.command.application.dto.board.ProjectApplyMemberDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.application.service.ProjectApplyMemberService;

@RestController
@RequestMapping("/api/v1/project/apply")
@RequiredArgsConstructor
@Tag(name = "Project Board Apply Member API", description = "프로젝트 게시물 신청 회원 API")
public class ProjectApplyMemberController {

    private final ProjectApplyMemberService projectApplyMemberService;

    // 프로젝트 신청 API
    @PostMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 신청", description = "프로젝트 신청 API")
    public ResponseEntity<ProjectApplyMember> applyForProject(
            @PathVariable Long projectBoardSeq,
            @RequestBody ProjectApplyMemberDTO applyMemberDTO) {

        // 서비스로 전달하여 신청 처리
        ProjectApplyMember applyMember = projectApplyMemberService.applyForProject(projectBoardSeq, applyMemberDTO);
        return ResponseEntity.ok(applyMember);
    }

    // 프로젝트 신청 취소 API
    @DeleteMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 신청 취소", description = "취소는 완전 삭제 기능 사용")
    public ResponseEntity<Void> cancelApplication(
            @PathVariable Long projectBoardSeq) {

        // userSeq는 SecurityContext에서 자동으로 가져옴
        projectApplyMemberService.cancelApplication(projectBoardSeq);
        return ResponseEntity.noContent().build();
    }
}
