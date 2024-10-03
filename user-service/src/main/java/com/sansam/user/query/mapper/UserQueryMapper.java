package com.sansam.user.query.mapper;


import com.sansam.user.query.dto.UserQueryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserQueryMapper {

    Optional<UserQueryDTO.LoginResponseDTO> findByUserId(String userId);

}
