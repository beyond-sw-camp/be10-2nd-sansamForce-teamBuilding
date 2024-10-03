package sansam.team.project.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ApiResponse;
import sansam.team.common.response.ResponseUtil;
import sansam.team.project.command.application.dto.AdminProjectApplyMemberDTO;
import sansam.team.project.command.application.dto.AdminProjectBoardCreateDTO;
import sansam.team.project.command.application.dto.AdminProjectBoardUpdateDTO;
import sansam.team.project.command.application.service.AdminProjectBoardService;
import sansam.team.project.command.domain.aggregate.entity.MentorReview;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;

@RestController
@RequestMapping("api/v1/admin/project/board")
@RequiredArgsConstructor
@Tag(name = "2-1. Project Board Admin API", description = "프로젝트 게시물 관리자 API")
public class AdminProjectBoardController {

    private final AdminProjectBoardService adminProjectBoardService;

    @PostMapping
    @Operation(summary = "프로젝트 게시물 추가", description = "프로젝트 게시물 추가 API (관리자만 가능)")
    public ApiResponse<?> createProjectBoard(
            @RequestBody AdminProjectBoardCreateDTO adminProjectBoardCreateDTO) {

        try {
            // 프로젝트 게시물 생성 요청
            ProjectBoard projectBoard = adminProjectBoardService.createProjectBoard(adminProjectBoardCreateDTO);

            return ResponseUtil.successResponse("Project created successfully").getBody();
        }catch (IllegalArgumentException e){

            return ResponseUtil.failureResponse(e.getMessage(), "USER_SEQ_NULL").getBody();
        }catch (Exception e){

            return ResponseUtil.exceptionResponse(e, "PROJECT_CREATE_ERROR").getBody();
        }

    }

    @PutMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 게시물 수정", description = "프로젝트 게시물 수정 API (관리자만 가능)")
    public ApiResponse<?> updateProjectBoard(
            @PathVariable Long projectBoardSeq,
            @RequestBody AdminProjectBoardUpdateDTO adminProjectBoardUpdateDTO) {

        try {
            // 프로젝트 게시물 업데이트 요청
            ProjectBoard updatedProjectBoard = adminProjectBoardService.updateProjectBoard(projectBoardSeq, adminProjectBoardUpdateDTO);

            return ResponseUtil.successResponse("Project updated successfully").getBody();
        }catch (IllegalArgumentException e){

            return ResponseUtil.failureResponse(e.getMessage(), "PROJECT_BOARD_SEQ_NULL").getBody();
        }catch (Exception e){

            return ResponseUtil.exceptionResponse(e, "PROJECT_UPDATE_ERROR").getBody();
        }
    }

    @DeleteMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 게시물 삭제", description = "프로젝트 게시물 삭제 API (관리자만 가능), 테스트 용도 삭제 API")
    public ApiResponse<?> deleteProjectBoard(@PathVariable Long projectBoardSeq) {
        try {
            // 프로젝트 게시물  삭제요청
            adminProjectBoardService.deleteProjectBoard(projectBoardSeq);

            return ResponseUtil.successResponse("Project deleted successfully").getBody();
        }catch (Exception e){

            return ResponseUtil.exceptionResponse(e, "PROJECT_DELETE_ERROR").getBody();
        }
    }

    // 신청 회원의 상태 업데이트 API
    @PutMapping("/{projectBoardSeq}/apply-member/{applyMemberSeq}")
    @Operation(summary = "프로젝트 게시물 신청 회원 상태 수정", description = "관리자가 해당 게시물에 신청한 회원의 상태를 조정하는 API")
    public ApiResponse<?> updateApplyMemberStatus(
            @PathVariable Long projectBoardSeq,
            @PathVariable Long applyMemberSeq,
            @RequestBody AdminProjectApplyMemberDTO adminProjectApplyMemberDTO) {

        try {
            // 서비스로 상태 업데이트 요청
            ProjectApplyMember updatedApplyMember = adminProjectBoardService.updateApplyMemberStatus(projectBoardSeq, applyMemberSeq, adminProjectApplyMemberDTO);

            // 성공 응답 반환
            return ResponseUtil.successResponse("Project board apply member updated successfully").getBody();
        } catch (IllegalArgumentException e) {
            // 실패 응답 반환 (예외 발생 시)
            return ResponseUtil.failureResponse(e.getMessage(), "APPLY_MEMBER_SEQ_NULL").getBody();
        } catch (Exception e) {
            // 그 외 예외 처리
            return ResponseUtil.exceptionResponse(e, "PROJECT_BOARD_APPLY_MEMBER_ERROR").getBody();
        }
    }
}