package sansam.team.project.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sansam.team.project.query.dto.projectboard.ProjectApplyMemberQueryDTO;
import sansam.team.project.query.dto.projectboard.ProjectBoardQueryDTO;

import java.util.List;

@Mapper
public interface ProjectBoardMapper {

    List<ProjectBoardQueryDTO> findAll();

    ProjectBoardQueryDTO findById(Long projectBoardSeq);

    // 특정 프로젝트에 신청한 회원들을 조회하는 메서드
    List<ProjectApplyMemberQueryDTO> findApplyMembersByProjectBoardSeq(@Param("projectBoardSeq") Long projectBoardSeq);
}
