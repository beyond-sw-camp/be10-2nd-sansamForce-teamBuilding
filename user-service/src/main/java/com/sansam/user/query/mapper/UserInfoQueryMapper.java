package com.sansam.user.query.mapper;


import com.sansam.user.query.dto.UserInfoResponseDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoQueryMapper {

    UserInfoResponseDTO findUserInfoByUserSeq(long userSeq);
}
