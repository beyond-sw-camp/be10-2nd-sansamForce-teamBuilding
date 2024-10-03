package com.sansam.project.command.application.service;


import com.sansam.project.command.application.dto.AdminProjectApplyMemberDTO;
import com.sansam.project.command.application.dto.AdminProjectBoardCreateDTO;
import com.sansam.project.command.application.dto.AdminProjectBoardUpdateDTO;
import com.sansam.project.command.domain.aggregate.entity.ProjectApplyMember;
import com.sansam.project.command.domain.aggregate.entity.ProjectBoard;
import com.sansam.project.command.domain.repository.ProjectApplyMemberRepository;
import com.sansam.project.command.domain.repository.ProjectBoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminProjectBoardService {

    private final ProjectBoardRepository projectBoardRepository;
    private final ProjectApplyMemberRepository projectApplyMemberRepository;
    private final ModelMapper modelMapper;

    /* 프로젝트 모집글 생성 로직 */
    @Transactional
    public ProjectBoard createProjectBoard(AdminProjectBoardCreateDTO adminProjectBoardCreateDTO) {

        CustomUserDTO user = SecurityUtil.getAuthenticatedUser();

        if(ObjectUtils.isEmpty(user.getUserSeq())){
            throw new IllegalArgumentException("User Seq is null");
        }

        ProjectBoard projectBoard = modelMapper.map(adminProjectBoardCreateDTO, ProjectBoard.class);
        projectBoard.setProjectBoardAdminSeq(user.getUserSeq());

        projectBoardRepository.save(projectBoard);

        return projectBoard;
    }

    /* 프로젝트 모집글 수정 로직 */
    @Transactional
    public ProjectBoard updateProjectBoard(Long projectBoardSeq, AdminProjectBoardUpdateDTO adminProjectBoardUpdateDTO) {

        // 기존 프로젝트 보드를 찾음
        ProjectBoard projectBoard = projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));

        projectBoard.modifyProjectBoard(adminProjectBoardUpdateDTO);

        // ModelMapper를 사용해 기존 ProjectBoard 객체에 업데이트 사항을 반영
        /*modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(projectBoardUpdateDTO, projectBoard);*/

        // 업데이트된 객체 저장 및 반환
        return projectBoard;
    }



    /* 프로젝트 모집글 삭제 로직 */
    @Transactional
    public void deleteProjectBoard(Long projectBoardSeq) {

        /* 완전 삭제로 할지 소프트 삭제로 할지 의논 후 제대로 구현해야 할 듯 */
        projectBoardRepository.deleteById(projectBoardSeq);
    }



    @Transactional
    public ProjectApplyMember updateApplyMemberStatus(Long projectBoardSeq, Long applyMemberSeq, AdminProjectApplyMemberDTO adminProjectApplyMemberDTO) {

        // 신청 회원(ProjectApplyMember) 존재 확인
        ProjectApplyMember applyMember = projectApplyMemberRepository.findById(applyMemberSeq)
                .orElseThrow(() -> new IllegalArgumentException("Apply member not found"));

        // 기존 프로젝트 보드를 찾음
        ProjectBoard projectBoard = projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));

        applyMember.modifyApplyMemberStatus(projectBoard.getProjectBoardSeq(), adminProjectApplyMemberDTO);

        // 저장
        return applyMember;
    }
}