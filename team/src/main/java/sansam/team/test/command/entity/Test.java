package sansam.team.test.command.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "test")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// @Setter, @AllArgsConstructor, @ToString 사용 지양
// -> Entity 수정 시 필요한 메서드를 직접 선언하여 사용
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    public void modifyContent(String content) {
        this.content = content;  // content 필드 초기화
    }
}
