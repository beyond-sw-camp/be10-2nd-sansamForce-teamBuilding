package sansam.team.project.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sansam.team.project.query.dto.ProjectApplyMemberQueryDTO;
import sansam.team.project.query.dto.ProjectBoardAllQueryDTO;
import sansam.team.project.query.dto.AdminProjectBoardDTO;
import sansam.team.project.query.dto.ProjectBoardDTO;

import java.util.List;

@Mapper
public interface ProjectBoardMapper {

    List<ProjectBoardAllQueryDTO> findAll();

    AdminProjectBoardDTO findByIdForAdmin(Long projectBoardSeq);

    ProjectBoardDTO findByIdForUser(Long projectBoardSeq);

    // 특정 프로젝트에 신청한 회원들을 조회하는 메서드
    List<ProjectApplyMemberQueryDTO> findApplyMembersByProjectBoardSeq(@Param("projectBoardSeq") Long projectBoardSeq);
}