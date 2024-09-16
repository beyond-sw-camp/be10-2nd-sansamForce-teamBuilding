package sansam.team.common.embedded;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class BaseEntity {

    @PrePersist
    public void onPrePersist(Auditable auditable) {
        LocalDateTime now = LocalDateTime.now();
        auditable.setCreatedAt(now);
        auditable.setUpdatedAt(now);
    }

    @PreUpdate
    public void onPreUpdate(Auditable auditable) {
        auditable.setUpdatedAt(LocalDateTime.now());
    }
}
