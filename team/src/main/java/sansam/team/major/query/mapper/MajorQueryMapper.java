package sansam.team.major.query.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sansam.team.major.query.dto.MajorQueryDTO;

import java.util.List;

@Mapper
public interface MajorQueryMapper {

    @Select("SELECT * FROM tbl_major WHERE major_seq = #{majorSeq}")
    MajorQueryDTO findById(Long majorSeq);

    @Select("SELECT * FROM tbl_major")
    List<MajorQueryDTO> findAll();
}
