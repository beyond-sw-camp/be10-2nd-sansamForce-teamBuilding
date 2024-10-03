package sansam.team.project.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.common.response.ApiResponse;
import sansam.team.project.query.dto.AdminProjectMemberAllQueryDTO;
import sansam.team.project.query.service.ProjectMemberQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/project")
@RequiredArgsConstructor
@Tag(name = "2-4. Project Member Admin API", description = "프로젝트 회원 관리자 API")
public class AdminProjectMemberQueryController {

    private final ProjectMemberQueryService projectMemberQueryService;

    // 프로젝트에 들어간 회원 전체 조회
    @Operation(summary = "프로젝트 회원 전체 조회", description = "프로젝트 번호로 해당 프로젝트의 회원들을 조회합니다.")
    @GetMapping("/{projectSeq}/member")
    public ApiResponse<List<AdminProjectMemberAllQueryDTO>> getProjectMembersByProjectSeq(@PathVariable Long projectSeq) {
        List<AdminProjectMemberAllQueryDTO> projectMembers = projectMemberQueryService.findProjectMembers(projectSeq);
        return ApiResponse.ofSuccess(projectMembers);
    }
}