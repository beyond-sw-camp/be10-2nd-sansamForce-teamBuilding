package sansam.team.common.embedded;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class BaseEntity {

    // 엔티티가 처음 저장될 때만 호출되어 regDate 설정
    @PrePersist
    public void onPrePersist(Object entity) {
        if (entity instanceof AuditableEntity) {
            AuditableEntity auditableEntity = (AuditableEntity) entity;
            Auditable auditable = auditableEntity.getAuditable();
            if (auditable == null) {
                auditable = new Auditable();
                auditableEntity.setAuditable(auditable);
            }
            // 등록 날짜만 설정
            auditable.setRegDate(LocalDateTime.now());
        }
    }

    // 엔티티가 수정될 때만 호출되어 modDate 설정
    @PreUpdate
    public void onPreUpdate(Object entity) {
        if (entity instanceof AuditableEntity) {
            AuditableEntity auditableEntity = (AuditableEntity) entity;
            Auditable auditable = auditableEntity.getAuditable();
            if (auditable != null) {
                // 수정 날짜만 설정
                auditable.setModDate(LocalDateTime.now());
            }
        }
    }

    // 논리 삭제를 구현하는 경우, delDate를 설정할 수 있는 메서드를 따로 구현
    public void markAsDeleted(AuditableEntity entity) {
        Auditable auditable = entity.getAuditable();
        if (auditable != null) {
            auditable.setDelDate(LocalDateTime.now());
        }
    }
}
