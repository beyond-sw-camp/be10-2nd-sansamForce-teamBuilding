package sansam.team.team.query.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/query/team")
@RequiredArgsConstructor
@Tag(name = "3-3. Team API", description = "팀 API")
public class TeamQueryController {

}
