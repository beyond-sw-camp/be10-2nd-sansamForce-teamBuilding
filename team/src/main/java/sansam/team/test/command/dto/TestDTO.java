package sansam.team.test.command.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor  // 기본 생성자
@AllArgsConstructor // 모든 필드를 받는 생성자
public class TestDTO {

    private String content;
}
