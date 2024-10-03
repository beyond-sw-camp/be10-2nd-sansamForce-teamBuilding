package com.sansam.project.command.application.controller;


import com.sansam.project.command.application.dto.AdminProjectApplyMemberDTO;
import com.sansam.project.command.application.service.ProjectApplyMemberService;
import com.sansam.project.command.domain.aggregate.entity.ProjectApplyMember;
import com.sansam.project.common.response.ApiResponse;
import com.sansam.project.common.response.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/project/board/apply")
@RequiredArgsConstructor
@Tag(name = "2-2. Project Board Apply Member API", description = "프로젝트 게시물 신청 회원 API")
public class ProjectApplyMemberController {

    private final ProjectApplyMemberService projectApplyMemberService;

    // 프로젝트 신청 API
    @PostMapping()
    @Operation(summary = "프로젝트 신청", description = "프로젝트 신청 API")
    public ApiResponse<?> applyForProject(
            @RequestBody AdminProjectApplyMemberDTO applyMemberDTO) {

        try {
            // 서비스로 전달하여 신청 처리
            ProjectApplyMember applyMember = projectApplyMemberService.applyForProject(applyMemberDTO);

            // 성공 응답 반환
            return ResponseUtil.successResponse("Project apply member created successfully").getBody();
        } catch (IllegalArgumentException e) {
            // 실패 응답 반환 (예외 발생 시)
            return ResponseUtil.failureResponse(e.getMessage(), "PROJECT_BOARD_SEQ_NULL").getBody();
        } catch (Exception e) {
            // 그 외 예외 처리
            return ResponseUtil.exceptionResponse(e, "PROJECT_APPLY_MEMBER_CREATE_ERROR").getBody();
        }
    }

    // 프로젝트 신청 취소 API
    @DeleteMapping("/{projectBoardSeq}")
    @Operation(summary = "프로젝트 신청 취소", description = "취소는 완전 삭제 기능 사용")
    public ApiResponse<?> cancelApplication(
            @PathVariable Long projectBoardSeq) {

        try {
            // 서비스로 전달하여 삭제 처리
            projectApplyMemberService.cancelApplication(projectBoardSeq);

            // 성공 응답 반환
            return ResponseUtil.successResponse("Project apply member deleted successfully").getBody();
        } catch (IllegalArgumentException e) {
            // 실패 응답 반환 (예외 발생 시)
            return ResponseUtil.failureResponse(e.getMessage(), "PROJECT_BOARD_SEQ_NULL").getBody();
        } catch (Exception e) {
            // 그 외 예외 처리
            return ResponseUtil.exceptionResponse(e, "PROJECT_APPLY_MEMBER_DELETE_ERROR").getBody();
        }
    }
}