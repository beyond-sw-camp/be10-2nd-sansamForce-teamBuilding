package sansam.team.user.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.user.query.dto.UserInfoResponseDTO;

@Mapper
public interface UserInfoQueryMapper {

    UserInfoResponseDTO findUserInfoByUserSeq(long userSeq);
}
