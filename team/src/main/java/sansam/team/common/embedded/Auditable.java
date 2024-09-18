package sansam.team.common.embedded;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter @Setter
public class Auditable {
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private LocalDateTime delDate;
}
