package sansam.team.project.command.application.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sansam.team.project.command.application.dto.project.ProjectCreateDTO;
import sansam.team.project.command.domain.aggregate.entity.Project;
import sansam.team.project.command.domain.repository.ProjectRepository;
import sansam.team.project.command.infrastructure.repository.JpaProjectRepository;
import jakarta.transaction.Transactional;
import sansam.team.user.command.domain.aggregate.entity.User;


@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    /* 프로젝트 생성 로직 */
    @Transactional
    public Project createProject(ProjectCreateDTO projectCreateDTO){
        // SecurityContext 에서 현재 진증된 사용자(User 객체) 추출
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        if(user.getUserSeq() == null){
            throw new IllegalArgumentException("User Seq is null");
        }

        Project project = modelMapper.map(projectCreateDTO, Project.class);
        project.setProjectAdminSeq(user.getUserSeq());

        projectRepository.save(project);

        return project;
    }
}
