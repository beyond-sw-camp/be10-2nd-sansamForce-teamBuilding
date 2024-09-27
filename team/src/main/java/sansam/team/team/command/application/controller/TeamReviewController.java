package sansam.team.team.command.application.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.team.command.application.dto.TeamReviewDTO;
import sansam.team.team.command.application.service.TeamReviewService;

@RestController
@RequestMapping("api/vi/team/review")
@Tag(name = "TeamReview API", description = "팀 평가 API")
@RequiredArgsConstructor
public class TeamReviewController {

    private final TeamReviewService teamReviewService;

    @PostMapping("/createReview")
    @Operation(summary = "팀 평가 추가")
    public ResponseEntity<String> createTeamReview(@RequestBody TeamReviewDTO reviewDTO) {
        boolean result = teamReviewService.createTeamReview(reviewDTO);

        return ResponseEntity.status(result ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST)
                .body(result ? "createTeamReview success" : "createTeamReview error");
    }
}

