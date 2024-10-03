package com.sansam.project.query.mapper;


import com.sansam.project.query.dto.AdminProjectQueryDTO;
import com.sansam.project.query.dto.ProjectAllQueryDTO;
import com.sansam.project.query.dto.ProjectQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectQueryMapper {

    List<ProjectAllQueryDTO> findAllProjectForAdmin();

    List<ProjectAllQueryDTO> findAllProjectForUser(Long userSeq);

    AdminProjectQueryDTO findProjectByIdForAdmin(Long projectSeq);

    ProjectQueryDTO findProjectByIdForUser(Long projectSeq);


}