package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.common.response.ApiResponse;
import sansam.team.team.command.application.dto.TeamReviewDTO;
import sansam.team.team.command.application.service.TeamReviewService;
import sansam.team.team.command.domain.aggregate.entity.TeamReview;

@RestController
@RequestMapping("api/vi/team/review")
@Tag(name = "TeamReview API", description = "팀 평가 API")
@RequiredArgsConstructor
public class TeamReviewController {

    private final TeamReviewService teamReviewService;

    @PostMapping("/createReview")
    @Operation(summary = "팀원 평가 추가")
    public ResponseEntity<String> createTeamReview(@RequestBody TeamReviewDTO reviewDTO) {
        boolean result = teamReviewService.createTeamReview(reviewDTO);

        return ResponseEntity.status(result ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
                .body(result ? "createTeamReview success" : "createTeamReview error");
    }

    @PutMapping("/{reviewSeq}")
    @Operation(summary = "팀원 평가 수정")
    public ApiResponse<TeamReview> updateTeamReview(@PathVariable long reviewSeq, @RequestBody TeamReviewDTO reviewDTO) {
        TeamReview teamReview = teamReviewService.updateTeamReview(reviewSeq, reviewDTO);

        return ApiResponse.ofSuccess(teamReview);
    }

    @DeleteMapping("/{reviewSeq}")
    @Operation(summary = "팀원 평가 삭제")
    public ApiResponse<String> deleteTeamReview(@PathVariable long reviewSeq) {
        teamReviewService.deleteTeamReview(reviewSeq);

        return ApiResponse.ofSuccess("삭제 성공");
    }

}

