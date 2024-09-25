package sansam.team.user.command.application.service.mypageservice;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.user.command.application.dto.mypagedto.MyPageDTO;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.command.domain.repository.mypagerepository.MyPageRepository;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MyPageRepository myPageRepository;

    @Transactional
    public void updateMyPage(MyPageDTO myPageDTO) {
        User user = myPageRepository.findById(myPageDTO.getUserSeq())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다."));

        user.updateUserInfo(
                myPageDTO.getUserNickname(),
                myPageDTO.getUserPhone(),
                myPageDTO.getUserEmail(),
                myPageDTO.getUserGithubId(),
                myPageDTO.getUserProfileImg()
        );

        myPageRepository.save(user);
    }
}
