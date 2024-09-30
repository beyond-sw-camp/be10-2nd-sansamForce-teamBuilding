package sansam.team.project.query.controller.project;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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
@Tag(name = "Project Member API", description = "프로젝트 회원 API")
public class ProjectMemberUserQueryController {

    private final ProjectQueryService projectQueryService;

    /**
     * 프로젝트 전체 조회 (사용자용)
     */
    @GetMapping
    @Operation(summary = "회원 별 프로젝트 전체 조회", description = "해당 사용자가 들어간 프로젝트 전체 조회")
    public List<ProjectAllQueryDTO> getAllProjectsForUser() {
        return projectQueryService.getAllProjectsForUser(null); // ResponseEntity 생략하고 DTO 반환
    }

    /**
     * 프로젝트 상세 조회 (사용자용)
     */
    @GetMapping("/{projectSeq}")
    @Operation(summary = "회원 별 프로젝트 상세 조회", description = "해당 사용자가 들어간 프로젝트 상세 조회")
    public ProjectUserQueryDTO getProjectByIdForUser(@PathVariable Long projectSeq) {
        return projectQueryService.getProjectByIdForUser(projectSeq); // ResponseEntity 생략하고 DTO 반환
    }
}
