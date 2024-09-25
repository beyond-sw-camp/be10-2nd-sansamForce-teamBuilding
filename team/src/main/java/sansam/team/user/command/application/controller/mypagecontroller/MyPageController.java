package sansam.team.user.command.application.controller.mypagecontroller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.user.command.application.dto.mypagedto.MyPageDTO;
import sansam.team.user.command.application.service.mypageservice.MyPageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class MyPageController {

    private final MyPageService myPageService;

    @PutMapping("/update")
    public ResponseEntity<String> updateMyPage(@RequestBody MyPageDTO myPageDTO) {

        myPageService.updateMyPage(myPageDTO);

        return ResponseEntity.ok("수정 성공");
    }


}

