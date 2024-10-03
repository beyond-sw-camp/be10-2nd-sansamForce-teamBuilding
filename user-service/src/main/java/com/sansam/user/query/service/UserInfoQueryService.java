package com.sansam.user.query.service;

import com.sansam.user.query.dto.UserInfoResponseDTO;
import com.sansam.user.query.mapper.UserInfoQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoQueryService {

    private final UserInfoQueryMapper userInfoQueryMapper;

    @Autowired
    public UserInfoQueryService(UserInfoQueryMapper userInfoQueryMapper) {
        this.userInfoQueryMapper = userInfoQueryMapper;
    }

    public UserInfoResponseDTO getUserInfo(Long userSeq) {
        return userInfoQueryMapper.findUserInfoByUserSeq(userSeq);
    }

}
