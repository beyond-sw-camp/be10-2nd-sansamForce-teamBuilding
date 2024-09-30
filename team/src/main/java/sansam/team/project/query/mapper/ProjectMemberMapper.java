package sansam.team.project.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sansam.team.project.query.dto.project.ProjectMemberAdminAllQueryDTO;

import java.util.List;

@Mapper
public interface ProjectMemberMapper {
    List<ProjectMemberAdminAllQueryDTO> findProjectMembersByProjectSeq(@Param("projectSeq") Long projectSeq);
}
