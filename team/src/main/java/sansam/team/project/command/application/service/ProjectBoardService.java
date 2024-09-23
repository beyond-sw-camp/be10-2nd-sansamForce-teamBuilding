package sansam.team.project.command.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sansam.team.common.jwt.SecurityUtil;
import sansam.team.project.command.application.dto.board.ProjectApplyMemberDTO;
import sansam.team.project.command.application.dto.board.ProjectBoardCreateDTO;
import sansam.team.project.command.application.dto.board.ProjectBoardUpdateDTO;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectBoard;
import sansam.team.project.command.domain.repository.ProjectApplyMemberRepository;
import sansam.team.project.command.domain.repository.ProjectBoardRepository;
import sansam.team.project.command.mapper.ProjectBoardMapper;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.command.infrastructure.repository.JpaUserRepository;

@Service
@RequiredArgsConstructor
public class ProjectBoardService {

    private final ProjectBoardRepository projectBoardRepository;
    private final ProjectApplyMemberRepository projectApplyMemberRepository;
    private final ModelMapper modelMapper;

    /* 프로젝트 모집글 생성 로직 */
    @Transactional
    public ProjectBoard createProjectBoard(ProjectBoardCreateDTO projectBoardCreateDTO) {

        User user = SecurityUtil.getAuthenticatedUser();

        if(user.getUserSeq() == null){
            throw new IllegalArgumentException("User Seq is null");
        }

        ProjectBoard projectBoard = modelMapper.map(projectBoardCreateDTO, ProjectBoard.class);
        projectBoard.setProjectBoardAdminSeq(user.getUserSeq());

        projectBoardRepository.save(projectBoard);

        return projectBoard;
    }

    /* 프로젝트 모집글 수정 로직 */
    @Transactional
    public ProjectBoard updateProjectBoard(Long projectBoardSeq, ProjectBoardUpdateDTO projectBoardUpdateDTO) {

        // 기존 프로젝트 보드를 찾음
        ProjectBoard projectBoard = projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));

        projectBoard.modifyProjectBoard(projectBoardUpdateDTO);

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
    public ProjectApplyMember updateApplyMemberStatus(Long projectBoardSeq, Long applyMemberSeq, ProjectApplyMemberDTO projectApplyMemberDTO) {

        // 신청 회원(ProjectApplyMember) 존재 확인
        ProjectApplyMember applyMember = projectApplyMemberRepository.findById(applyMemberSeq)
                .orElseThrow(() -> new IllegalArgumentException("Apply member not found"));

        // 기존 프로젝트 보드를 찾음
        ProjectBoard projectBoard = projectBoardRepository.findById(projectBoardSeq)
                .orElseThrow(() -> new IllegalArgumentException("Project board not found"));

        applyMember.modifyApplyMemberStatus(projectBoard.getProjectBoardSeq(), projectApplyMemberDTO);

        // 저장
        return applyMember;
    }
}
