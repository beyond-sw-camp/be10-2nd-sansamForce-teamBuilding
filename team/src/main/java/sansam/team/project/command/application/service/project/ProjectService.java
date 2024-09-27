package sansam.team.project.command.application.service.project;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sansam.team.common.jwt.SecurityUtil;
import sansam.team.project.command.application.dto.project.ProjectCreateDTO;
import sansam.team.project.command.application.dto.project.ProjectUpdateDTO;
import sansam.team.project.command.domain.aggregate.entity.Project;
import sansam.team.project.command.domain.repository.project.ProjectRepository;
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

        User user = SecurityUtil.getAuthenticatedUser();

        if(user.getUserSeq() == null){
            throw new IllegalArgumentException("User Seq is null");
        }

        if(projectCreateDTO.getProjectStartDate().isBefore(projectCreateDTO.getProjectEndDate())) {
            throw new IllegalArgumentException("Project Date Check Error");
        }

        Project project = modelMapper.map(projectCreateDTO, Project.class);
        project.setProjectAdminSeq(user.getUserSeq());

        projectRepository.save(project);

        return project;
    }

    /* 프로젝트 수정 로직 */
    @Transactional
    public Project updateProject(Long projectSeq, ProjectUpdateDTO projectUpdateDTO){

        // 기존 프로젝트를 찾음
        Project project = projectRepository.findById(projectSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        project.modifyProject(projectUpdateDTO);

        return project;
    }

    /* 프로젝트 삭제 로직 */
    @Transactional
    public void deleteProject(Long projectSeq){

        /* 완전 삭제로 할지 소프트 삭제로 할지 의논 후 제대로 구현해야 함 */
        projectRepository.deleteById(projectSeq);
    }
}
