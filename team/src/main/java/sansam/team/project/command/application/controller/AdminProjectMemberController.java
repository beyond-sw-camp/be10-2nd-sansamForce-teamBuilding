package sansam.team.project.command.application.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.project.command.application.dto.AdminProjectMemberUpdateDTO;
import sansam.team.project.command.application.service.AdminProjectMemberService;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;

@RestController
@RequestMapping("/api/v1/admin/project/member")
@RequiredArgsConstructor
@Tag(name = "Project Member Admin API", description = "프로젝트 회원 관리자 API")
public class AdminProjectMemberController {

    private final AdminProjectMemberService adminProjectMemberService;

    // 프로젝트 멤버 생성 엔드포인트
    @PostMapping("/{projectSeq}")
    @Operation(summary = "프로젝트 회원 추가", description = "프로젝트 회원 추가 API (관리자만 가능)")
    public ResponseEntity<ProjectMember> addProjectMember(
            @PathVariable Long projectSeq,
            @RequestParam Long userSeq) {  // 요청 파라미터로 userSeq 받기

        // 주어진 userSeq와 프로젝트 정보를 이용해 멤버 추가
        ProjectMember projectMember = adminProjectMemberService.containForProject(projectSeq, userSeq);

        return ResponseEntity.ok(projectMember);
    }

    // 프로젝트 멤버 수정 엔드포인트
    @PutMapping("/{projectMemberSeq}")
    @Operation(summary = "프로젝트 회원 상태 변경(탈퇴 유무, 멘토 유무)", description = "프로젝트 수정 API (관리자만 가능)")
    public ResponseEntity<ProjectMember> updateProjectMember(
            @PathVariable Long projectMemberSeq,
            @RequestBody AdminProjectMemberUpdateDTO updateDTO) {

        ProjectMember updatedProjectMember = adminProjectMemberService.updateProjectMember(projectMemberSeq, updateDTO);

        return ResponseEntity.ok(updatedProjectMember);
    }
}

