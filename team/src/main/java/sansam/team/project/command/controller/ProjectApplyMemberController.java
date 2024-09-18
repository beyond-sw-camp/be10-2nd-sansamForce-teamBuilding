package sansam.team.project.command.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.project.command.dto.projectboard.ProjectApplyMemberDTO;
import sansam.team.project.command.entity.ProjectApplyMember;
import sansam.team.project.command.service.ProjectApplyMemberService;

@RestController
@RequestMapping("/api/project/apply")
@RequiredArgsConstructor
public class ProjectApplyMemberController {

    private final ProjectApplyMemberService projectApplyMemberService;

    // 프로젝트 신청 API
    @PostMapping("/{projectBoardSeq}")
    public ResponseEntity<ProjectApplyMember> applyForProject(
            @PathVariable Long projectBoardSeq,
            @RequestBody ProjectApplyMemberDTO projectApplyMemberDTO) {

        ProjectApplyMember applyMember = projectApplyMemberService.applyForProject(projectBoardSeq, projectApplyMemberDTO);
        return ResponseEntity.ok(applyMember);
    }

    // 프로젝트 신청 취소 API
    @DeleteMapping("/{projectBoardSeq}")
    public ResponseEntity<Void> cancelApplication(
            @PathVariable Long projectBoardSeq) {

        // userSeq는 SecurityContext에서 자동으로 가져옴
        projectApplyMemberService.cancelApplication(projectBoardSeq);
        return ResponseEntity.noContent().build();
    }
}
