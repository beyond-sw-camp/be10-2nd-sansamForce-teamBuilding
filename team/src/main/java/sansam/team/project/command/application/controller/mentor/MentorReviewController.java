package sansam.team.project.command.application.controller.mentor;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ApiResponse;
import sansam.team.common.response.ResponseUtil;
import sansam.team.project.command.application.dto.mentor.MentorReviewDTO;
import sansam.team.project.command.domain.aggregate.entity.MentorReview;
import sansam.team.project.command.application.service.mentor.MentorReviewService;

@RestController
@RequestMapping("/api/mentor-reviews")
@RequiredArgsConstructor
public class MentorReviewController {

    private final MentorReviewService mentorReviewService;

    @PostMapping("/{userSeq}")
    public ApiResponse<?> createMentorReview(
            @PathVariable Long userSeq,
            @RequestBody MentorReviewDTO mentorReviewDTO) {
        try {
            // MentorReview 생성
            MentorReview mentorReview = mentorReviewService.createMentorReview(userSeq, mentorReviewDTO);

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
}
