package sansam.team.user.command.application.service.mypageservice;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.updateUserInfo(myPageDTO);
    }
}
