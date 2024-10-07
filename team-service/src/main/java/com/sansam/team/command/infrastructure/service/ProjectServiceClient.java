package com.sansam.team.client;

import com.sansam.team.client.dto.MentorReviewDTO;
import com.sansam.team.client.dto.ProjectMemberDTO;
import com.sansam.team.client.dto.ProjectMemberUpdateDTO;
import com.sansam.team.client.dto.UserDTO;
import com.sansam.team.common.response.ApiResponse;
import com.sansam.team.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "project-service", url = "localhost:8000", configuration = FeignClientConfig.class)
public interface ProjectServiceClient {

    @GetMapping("/api/v1/project/member/{projectMember}")
    ProjectMemberDTO findProjectMemberById(@PathVariable("projectMember") Long projectMember);

    @PutMapping("/api/v1/admin/project/{projectSeq}/member/{projectMemberSeq}")
    ApiResponse<?> modifyProjectMember(@PathVariable Long projectMemberSeq, ProjectMemberUpdateDTO pjMemberUpdateDTO);

    @GetMapping("/api/v1/project/mentor/review/{projectMemberSeq}")
    ApiResponse<List<MentorReviewDTO>> findMentorReviewByProjectMemberSeq(@PathVariable Long projectMemberSeq);

    @GetMapping("/api/v1/project/{projectSeq}/member")
    List<ProjectMemberDTO> findProjectMemberByProjectSeq(@PathVariable Long projectSeq);
}
