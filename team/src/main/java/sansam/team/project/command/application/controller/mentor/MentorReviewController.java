package sansam.team.project.command.application.controller.mentor;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ApiResponse;
import sansam.team.common.response.ResponseUtil;
import sansam.team.project.command.application.dto.mentor.MentorReviewDTO;
import sansam.team.project.command.domain.aggregate.entity.MentorReview;
import sansam.team.project.command.application.service.mentor.MentorReviewService;

@RestController
@RequestMapping("/api/v1/project/mentor/review")
@RequiredArgsConstructor
@Tag(name = "Project Mentor Review API", description = "프로젝트 강사 평가 API")
public class MentorReviewController {

    private final MentorReviewService mentorReviewService;

    /* 강사 평가 추가 로직 */
    @PostMapping("/{projectMemberSeq}")
    @Operation(summary = "프로젝트 별 강사 평가 추가 API", description = "강사만 평가 추가를 할 수 있음")
    public ApiResponse<?> createMentorReview(
            @PathVariable Long projectMemberSeq,
            @RequestBody MentorReviewDTO mentorReviewDTO) {
        try {
            // MentorReview 생성
            MentorReview mentorReview = mentorReviewService.createMentorReview(projectMemberSeq, mentorReviewDTO);

            // 성공 응답 반환
            return ResponseUtil.successResponse("Mentor review created successfully").getBody();
        } catch (IllegalArgumentException e) {
            // 실패 응답 반환 (예외 발생 시)
            return ResponseUtil.failureResponse(e.getMessage(), "USER_SEQ_NULL").getBody();
        } catch (Exception e) {
            // 그 외 예외 처리
            return ResponseUtil.exceptionResponse(e, "MENTOR_REVIEW_ERROR").getBody();
        }
    }

    /* 강사 평가 수정 로직 */
    @PutMapping("/{projectMemberSeq}")
    @Operation(summary = "프로젝트 별 강사 평가 수정 API", description = "강사만 평가 수정을 할 수 있음")
    public ApiResponse<?> updateMentorReview(
            @PathVariable Long projectMemberSeq,
            @RequestBody MentorReviewDTO mentorReviewDTO) {
        try {
            // MentorReview 수정
            MentorReview updatedMentorReview = mentorReviewService.updateMentorReview(projectMemberSeq, mentorReviewDTO);

            // 성공 응답 반환
            return ResponseUtil.successResponse("Mentor review updated successfully").getBody();
        } catch (IllegalArgumentException e) {
            // 실패 응답 반환 (예외 발생 시)
            return ResponseUtil.failureResponse(e.getMessage(), "MENTOR_REVIEW_NOT_FOUND").getBody();
        } catch (Exception e) {
            // 그 외 예외 처리
            return ResponseUtil.exceptionResponse(e, "MENTOR_REVIEW_UPDATE_ERROR").getBody();
        }
    }

    /* 멘토 평가 삭제 로직 */
    @DeleteMapping("/{projectMemberSeq}")
    @Operation(summary = "프로젝트 별 강사 평가 삭제 API", description = "강사만 평가 삭제를 할 수 있음")
    public ApiResponse<?> deleteMentorReview(@PathVariable Long projectMemberSeq) {
        try {
            // MentorReview 삭제
            mentorReviewService.deleteMentorReview(projectMemberSeq);

            // 성공 응답 반환
            return ResponseUtil.successResponse("Mentor review deleted successfully").getBody();
        } catch (IllegalArgumentException e) {
            // 실패 응답 반환 (예외 발생 시)
            return ResponseUtil.failureResponse(e.getMessage(), "MENTOR_REVIEW_NOT_FOUND").getBody();
        } catch (Exception e) {
            // 그 외 예외 처리
            return ResponseUtil.exceptionResponse(e, "MENTOR_REVIEW_DELETE_ERROR").getBody();
        }
    }
}
