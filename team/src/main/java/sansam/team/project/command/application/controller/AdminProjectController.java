package sansam.team.project.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.project.command.application.dto.AdminProjectCreateDTO;
import sansam.team.project.command.application.dto.AdminProjectUpdateDTO;
import sansam.team.project.command.application.service.AdminProjectService;
import sansam.team.project.command.domain.aggregate.entity.Project;

@RestController
@RequestMapping("api/v1/admin/project")
@RequiredArgsConstructor
@Tag(name = "2-3. Project Admin API", description = "프로젝트 관리자 API")
public class AdminProjectController {

    private final AdminProjectService adminProjectService;

    @PostMapping
    @Operation(summary = "프로젝트 추가", description = "프로젝트 추가 API (관리자만 가능)")
    public ResponseEntity<Project> createProject(@RequestBody AdminProjectCreateDTO projectDTO) {

        Project creatProject = adminProjectService.createProject(projectDTO);

        return ResponseEntity.ok(creatProject);
    }

    @PutMapping("/{projectSeq}")
    @Operation(summary = "프로젝트 수정", description = "프로젝트 수정 API (관리자만 가능)")
    public ResponseEntity<Project> updateProjectBoard(
            @PathVariable Long projectSeq,
            @RequestBody AdminProjectUpdateDTO adminProjectUpdateDTO) {
        // 프로젝트 게시물 업데이트 요청
        Project updateProject = adminProjectService.updateProject(projectSeq, adminProjectUpdateDTO);

        return ResponseEntity.ok(updateProject);
    }

    @DeleteMapping("/{projectSeq}")
    @Operation(summary = "프로젝트 삭제", description = "프로젝트 삭제 API (관리자만 가능), 테스트 용도 삭제 API")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectSeq) {
        adminProjectService.deleteProject(projectSeq);

        return ResponseEntity.noContent().build();
    }

}
