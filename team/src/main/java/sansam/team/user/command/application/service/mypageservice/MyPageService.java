package sansam.team.user.command.application.service.mypageservice;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sansam.team.common.jwt.SecurityUtil;
import sansam.team.user.command.application.dto.mypagedto.MyPageDTO;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.command.domain.repository.mypagerepository.MyPageRepository;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MyPageRepository myPageRepository;

    @Transactional
    public User updateMyPage(MyPageDTO myPageDTO) {

        User user = SecurityUtil.getAuthenticatedUser();

        if (user.getUserSeq() == null) {
            throw new IllegalArgumentException("User Seq is null");
        }

        // User 엔티티 업데이트
        user.updateMyPageList(myPageDTO);

        return user;
    }
}
