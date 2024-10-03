package com.sansam.project.query.service;


import com.sansam.project.query.dto.AdminProjectBoardDTO;
import com.sansam.project.query.dto.ProjectApplyMemberQueryDTO;
import com.sansam.project.query.dto.ProjectBoardAllQueryDTO;
import com.sansam.project.query.dto.ProjectBoardDTO;
import com.sansam.project.query.mapper.ProjectBoardQueryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectBoardQueryService {

    private final ProjectBoardQueryMapper projectBoardMapper;

    /* 프로젝트 게시물 전체 조회 */
    public List<ProjectBoardAllQueryDTO> getAllProjectBoards(){
        return projectBoardMapper.findAll();
    }

    /* 프로젝트 게시물 상세 조회 (관리자) */
    public AdminProjectBoardDTO getProjectBoardByIdForAdmin(Long projectBoardSeq) {
        return projectBoardMapper.findByIdForAdmin(projectBoardSeq);
    }

    /* 프로젝트 게시물 상세 조회 (사용자) */
    public ProjectBoardDTO getProjectBoardByIdForUser(Long projectBoardSeq){
        return projectBoardMapper.findByIdForUser(projectBoardSeq);
    }

    /* 프로젝트 신청 회원 리스트 조회 */
    public List<ProjectApplyMemberQueryDTO> findApplyMembersByProjectBoardSeq(Long projectBoardSeq) {
        return projectBoardMapper.findApplyMembersByProjectBoardSeq(projectBoardSeq);
    }

}