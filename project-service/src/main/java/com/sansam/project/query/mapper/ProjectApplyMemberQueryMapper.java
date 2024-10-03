package com.sansam.project.query.mapper;


import com.sansam.project.query.dto.ApplyMemberQueryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectApplyMemberQueryMapper {

    // 특정 회원이 신청한 프로젝트 목록을 조회하는 메서드
    List<ApplyMemberQueryDTO> findProjectsByUserSeq(@Param("userSeq") Long userSeq);
}