package sansam.team.project.query.controller;

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
public class ProjectUserQueryController {

    private final ProjectQueryService projectQueryService;

    /**
     * 프로젝트 전체 조회 (사용자용)
     */
    @GetMapping
    public ResponseEntity<List<ProjectAllQueryDTO>> getAllProjectsForUser() {
        List<ProjectAllQueryDTO> projects = projectQueryService.getAllProjectsForUser(null);
        return ResponseEntity.ok(projects);
    }

    /**
     * 프로젝트 상세 조회 (사용자용)
     */
    @GetMapping("/user/{projectSeq}")
    public ResponseEntity<ProjectUserQueryDTO> getProjectByIdForUser(@PathVariable Long projectSeq) {
        ProjectUserQueryDTO project = projectQueryService.getProjectByIdForUser(projectSeq);
        return ResponseEntity.ok(project);
    }
}
