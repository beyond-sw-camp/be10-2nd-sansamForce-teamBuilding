package com.sansam.project.query.controller;

import com.sansam.project.common.response.ApiResponse;
import com.sansam.project.query.dto.ProjectBoardAllQueryDTO;
import com.sansam.project.query.dto.ProjectBoardDTO;
import com.sansam.project.query.service.ProjectBoardQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/project/board")
@RequiredArgsConstructor
@Tag(name = "2-1. Project Board User API", description = "프로젝트 게시물 유저 API")
public class ProjectBoardQueryController {

    private final ProjectBoardQueryService projectBoardQueryService;

    /* 프로젝트 게시물 전체 조회 */
    @GetMapping
    @Operation(summary = "프로젝트 게시물 전체 조회", description = "프로젝트 게시물 전체 조회 API (사용자가 조회)")
    public ApiResponse<List<ProjectBoardAllQueryDTO>> getAllProjectBoards() {
        List<ProjectBoardAllQueryDTO> projectBoards = projectBoardQueryService.getAllProjectBoards();
        return ApiResponse.ofSuccess(projectBoards);
    }

    /* 프로젝트 게시물 상세 조회 */
    @GetMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 게시물 상세 조회", description = "프로젝트 게시물 상세 조회 API (사용자가 조회)")
    public ApiResponse<ProjectBoardDTO> getProjectBoardById(@PathVariable Long projectBoardSeq) {
        ProjectBoardDTO projectBoard = projectBoardQueryService.getProjectBoardByIdForUser(projectBoardSeq);
        return ApiResponse.ofSuccess(projectBoard);
    }
}