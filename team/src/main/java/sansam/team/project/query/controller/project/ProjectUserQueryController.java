package sansam.team.project.query.controller.project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.project.query.dto.project.ProjectAllQueryDTO;
import sansam.team.project.query.dto.project.ProjectUserQueryDTO;
import sansam.team.project.query.service.ProjectQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
@Tag(name = "Project Member Admin API", description = "프로젝트 회원 관리자 API")
public class ProjectUserQueryController {

    private final ProjectQueryService projectQueryService;

    /**
     * 프로젝트 전체 조회 (사용자용)
     */
    @GetMapping
    @Operation(summary = "회원 별 프로젝트 전체 조회", description = "해당 사용자가 들어간 프로젝트 전체 조회")
    public ResponseEntity<List<ProjectAllQueryDTO>> getAllProjectsForUser() {
        List<ProjectAllQueryDTO> projects = projectQueryService.getAllProjectsForUser(null);
        return ResponseEntity.ok(projects);
    }

    /**
     * 프로젝트 상세 조회 (사용자용)
     */
    @GetMapping("/user/{projectSeq}")
    @Operation(summary = "회원 별 프로젝트 상세 조회", description = "해당 사용자가 들어간 프로젝트 상세 조회")
    public ResponseEntity<ProjectUserQueryDTO> getProjectByIdForUser(@PathVariable Long projectSeq) {
        ProjectUserQueryDTO project = projectQueryService.getProjectByIdForUser(projectSeq);
        return ResponseEntity.ok(project);
    }
}
