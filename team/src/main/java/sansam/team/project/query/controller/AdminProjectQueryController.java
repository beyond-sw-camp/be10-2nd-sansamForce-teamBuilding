package sansam.team.project.query.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.common.response.ApiResponse;
import sansam.team.project.query.dto.AdminProjectQueryDTO;
import sansam.team.project.query.dto.ProjectAllQueryDTO;
import sansam.team.project.query.service.ProjectQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/project")
@RequiredArgsConstructor
@Tag(name = "2-3. Project Admin API", description = "프로젝트 관리자 API")
public class AdminProjectQueryController {

    private final ProjectQueryService projectQueryService;

    /**
     * 프로젝트 전체 조회 (관리자용)
     */
    @GetMapping
    @Operation(summary = "프로젝트 전체 조회", description = "프로젝트 전체 조회 API (관리자만 가능)")
    public ApiResponse<List<ProjectAllQueryDTO>> getAllProjectsForAdmin() {
        List<ProjectAllQueryDTO> projects = projectQueryService.getAllProjectsForAdmin();
        return ApiResponse.ofSuccess(projects);
    }

    /**
     * 프로젝트 상세 조회 (관리자용)
     */
    @GetMapping("/{projectSeq}")
    @Operation(summary = "프로젝트 상세 조회", description = "프로젝트 상세 조회 API (관리자만 가능)")
    public ApiResponse<AdminProjectQueryDTO> getProjectByIdForAdmin(@PathVariable Long projectSeq) {
        AdminProjectQueryDTO project = projectQueryService.getProjectByIdForAdmin(projectSeq);
        return ApiResponse.ofSuccess(project);
    }
}
