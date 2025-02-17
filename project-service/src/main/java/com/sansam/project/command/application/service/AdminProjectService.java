package com.sansam.project.command.application.service;


import com.sansam.project.command.application.dto.AdminProjectCreateDTO;
import com.sansam.project.command.application.dto.AdminProjectUpdateDTO;
import com.sansam.project.command.domain.aggregate.entity.Project;
import com.sansam.project.command.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    /* 프로젝트 생성 로직 */
    @Transactional
    public Project createProject(AdminProjectCreateDTO adminProjectCreateDTO){

        CustomUserDTO user = SecurityUtil.getAuthenticatedUser();

        if(ObjectUtils.isEmpty(user.getUserSeq())){
            throw new IllegalArgumentException("User Seq is null");
        }

        if(adminProjectCreateDTO.getProjectStartDate().isBefore(adminProjectCreateDTO.getProjectEndDate())) {
            throw new IllegalArgumentException("Project Date Check Error");
        }

        Project project = modelMapper.map(adminProjectCreateDTO, Project.class);
        project.setProjectAdminSeq(user.getUserSeq());

        projectRepository.save(project);

        return project;
    }

    /* 프로젝트 수정 로직 */
    @Transactional
    public Project updateProject(Long projectSeq, AdminProjectUpdateDTO adminProjectUpdateDTO){

        // 기존 프로젝트를 찾음
        Project project = projectRepository.findById(projectSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        project.modifyProject(adminProjectUpdateDTO);

        return project;
    }

    /* 프로젝트 삭제 로직 */
    @Transactional
    public void deleteProject(Long projectSeq){

        /* 완전 삭제로 할지 소프트 삭제로 할지 의논 후 제대로 구현해야 함 */
        projectRepository.deleteById(projectSeq);
    }
}