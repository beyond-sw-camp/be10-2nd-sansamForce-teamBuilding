package sansam.team.user.command.application.controller.mypagecontroller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sansam.team.user.command.application.dto.mypagedto.MyPageDTO;
import sansam.team.user.command.application.service.mypageservice.MyPageService;
import sansam.team.user.command.domain.aggregate.entity.User;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class MyPageController {

    private final MyPageService myPageService;

    @PutMapping("/update")
    public ResponseEntity<User> updateMyPage(@RequestBody MyPageDTO myPageDTO) {

        User updateUser = myPageService.updateMyPage(myPageDTO);

        return ResponseEntity.ok(updateUser);
    }


}

