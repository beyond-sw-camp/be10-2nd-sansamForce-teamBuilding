package sansam.team.user.command.application.controller.mypagecontroller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sansam.team.user.command.application.dto.mypagedto.MyPageDTO;
import sansam.team.user.command.application.service.mypageservice.MyPageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/update")
    public ResponseEntity<?> updateMyPage(@RequestBody MyPageDTO myPageDTO) {
        myPageService.updateMyPage(myPageDTO);
        return ResponseEntity.ok("수정 성공");
    }


}

