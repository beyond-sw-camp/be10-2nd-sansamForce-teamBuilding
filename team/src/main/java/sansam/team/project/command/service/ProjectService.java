package sansam.team.project.command.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sansam.team.project.command.dto.project.ProjectDTO;
import sansam.team.project.command.entity.Project;
import sansam.team.project.command.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import sansam.team.user.command.entity.User;


@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    /* 프로젝트 생성 로직 */
    @Transactional
    public Project createProject(ProjectDTO projectDTO){
        // SecurityContext 에서 현재 진증된 사용자(User 객체) 추출
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        if(user.getUserSeq() == null){
            throw new IllegalArgumentException("User Seq is null");
        }

        Project project = new Project(
                projectDTO.getProjectTitle(),
                projectDTO.getProjectContent(),
                projectDTO.getProjectStatus(),
                projectDTO.getProjectHeadCount(),
                projectDTO.getProjectImgUrl(),
                projectDTO.getProjectStartDate(),
                projectDTO.getProjectEndDate(),
                user
        );

        return projectRepository.save(project);
    }
}
