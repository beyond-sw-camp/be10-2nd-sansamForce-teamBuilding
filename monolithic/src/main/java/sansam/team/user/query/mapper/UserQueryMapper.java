package sansam.team.user.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.user.query.dto.UserQueryDTO;

import java.util.Optional;

@Mapper
public interface UserQueryMapper {

    Optional<UserQueryDTO.LoginResponseDTO> findByUserId(String userId);

}
