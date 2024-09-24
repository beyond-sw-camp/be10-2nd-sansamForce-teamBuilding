package sansam.team.project.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.common.jwt.SecurityUtil;
import sansam.team.project.command.application.dto.project.ProjectMemberCreateDTO;
import sansam.team.project.command.domain.aggregate.entity.Project;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;
import sansam.team.project.command.domain.repository.ProjectMemberRepository;
import sansam.team.project.command.domain.repository.ProjectRepository;
import sansam.team.project.command.mapper.ProjectMemberMapper;
import sansam.team.user.command.domain.aggregate.entity.User;

@Service
@RequiredArgsConstructor
public class ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectMember containForProject(final Long projectSeq, ProjectMemberCreateDTO projectMemberCreateDTO){

        // SecurityContext에서 현재 인증된 사용자(User 객체) 추출
        User user = SecurityUtil.getAuthenticatedUser();

        // 추출한 User의 userSeq가 null이 아닌지 확인
        if (user.getUserSeq() == null) {
            throw new IllegalArgumentException("User Seq is null");
        }

        Project project = projectRepository.findById(projectSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        ProjectMember projectMember = ProjectMemberMapper.toEntity(user.getUserSeq(), project.getProjectSeq(), projectMemberCreateDTO);

        projectMemberRepository.save(projectMember);

        return projectMember;

    }

}
