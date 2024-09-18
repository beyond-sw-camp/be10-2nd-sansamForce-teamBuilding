package sansam.team.project.command.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.project.command.dto.ProjectBoardDTO;
import sansam.team.project.command.entity.ProjectBoard;
import sansam.team.project.command.service.ProjectBoardService;

@RestController
@RequestMapping("api/v1/admin/project/board")
@RequiredArgsConstructor
public class ProjectBoardController {

    private final ProjectBoardService projectBoardService;

    @PostMapping
    public ResponseEntity<ProjectBoard> createProjectBoard(
            @RequestBody ProjectBoardDTO projectBoardDTO) {
        // 서비스로 전달하여 ProjectBoard 생성
        ProjectBoard projectBoard = projectBoardService.createProjectBoard(projectBoardDTO);
        return ResponseEntity.ok(projectBoard);
    }

    @PutMapping("/{projectBoardSeq}")
    public ResponseEntity<ProjectBoard> updateProjectBoard(
            @PathVariable Long projectBoardSeq,
            @RequestBody ProjectBoardDTO projectBoardDTO) {
        ProjectBoard updatedProjectBoard = projectBoardService.updateProjectBoard(projectBoardSeq, projectBoardDTO);
        return ResponseEntity.ok(updatedProjectBoard);
    }

    @DeleteMapping("/{projectBoardSeq}")
    public ResponseEntity<Void> deleteProjectBoard(@PathVariable Long projectBoardSeq) {
        projectBoardService.deleteProjectBoard(projectBoardSeq);
        return ResponseEntity.noContent().build();
    }
}
