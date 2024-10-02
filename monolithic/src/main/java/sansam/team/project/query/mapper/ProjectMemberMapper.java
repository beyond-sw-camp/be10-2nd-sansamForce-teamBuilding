package sansam.team.project.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sansam.team.project.query.dto.AdminProjectMemberAllQueryDTO;

import java.util.List;

@Mapper
public interface ProjectMemberMapper {
    List<AdminProjectMemberAllQueryDTO> findProjectMembersByProjectSeq(@Param("projectSeq") Long projectSeq);
}
