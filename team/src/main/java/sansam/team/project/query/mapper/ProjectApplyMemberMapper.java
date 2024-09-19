package sansam.team.project.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sansam.team.project.query.dto.projectboard.ApplyMemberQueryDTO;

import java.util.List;

@Mapper
public interface ProjectApplyMemberMapper {

    // 특정 회원이 신청한 프로젝트 목록을 조회하는 메서드
    List<ApplyMemberQueryDTO> findProjectsByUserSeq(@Param("userSeq") Long userSeq);
}
