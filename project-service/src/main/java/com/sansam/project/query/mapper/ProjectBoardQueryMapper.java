package com.sansam.project.query.mapper;


import com.sansam.project.query.dto.AdminProjectBoardDTO;
import com.sansam.project.query.dto.ProjectApplyMemberQueryDTO;
import com.sansam.project.query.dto.ProjectBoardAllQueryDTO;
import com.sansam.project.query.dto.ProjectBoardDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectBoardQueryMapper {

    List<ProjectBoardAllQueryDTO> findAll();

    AdminProjectBoardDTO findByIdForAdmin(Long projectBoardSeq);

    ProjectBoardDTO findByIdForUser(Long projectBoardSeq);

    // 특정 프로젝트에 신청한 회원들을 조회하는 메서드
    List<ProjectApplyMemberQueryDTO> findApplyMembersByProjectBoardSeq(@Param("projectBoardSeq") Long projectBoardSeq);
}