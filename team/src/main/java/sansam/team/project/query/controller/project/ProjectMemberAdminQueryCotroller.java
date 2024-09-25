package sansam.team.project.query.controller.project;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/project/member")
@RequiredArgsConstructor
@Tag(name = "Project Member Admin API", description = "프로젝트 회원 관리자 API")
public class ProjectMemberAdminQueryCotroller {
}
