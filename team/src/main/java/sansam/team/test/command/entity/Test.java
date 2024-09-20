package sansam.team.test.command.entity;

import jakarta.persistence.*;
import lombok.*;
import sansam.team.common.BaseTimeEntity;

@Entity
@Table(name = "test")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SequenceGenerator(
        name = "TEST_SEQ_GENERATOR",
        sequenceName = "TEST_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)
// @Setter, @AllArgsConstructor, @ToString 사용 지양
// -> Entity 수정 시 필요한 메서드를 직접 선언하여 사용
public class Test extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "TEST_SEQ_GENERATOR")
    private Long id;

    private String content;

    public void modifyContent(String content) {
        this.content = content;  // content 필드 초기화
    }
}
