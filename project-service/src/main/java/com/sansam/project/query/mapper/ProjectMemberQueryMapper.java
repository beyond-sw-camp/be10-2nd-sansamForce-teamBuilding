package com.sansam.project.query.mapper;


import com.sansam.project.query.dto.AdminProjectMemberAllQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMemberQueryMapper {
    List<AdminProjectMemberAllQueryDTO> findProjectMembersByProjectSeq(@Param("projectSeq") Long projectSeq);
}