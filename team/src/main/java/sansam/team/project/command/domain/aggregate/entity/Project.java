package sansam.team.project.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.BaseTimeEntity;
import sansam.team.project.command.domain.aggregate.ProjectStatus;
import sansam.team.user.command.domain.aggregate.entity.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_project")
@Getter
@NoArgsConstructor
public class Project extends BaseTimeEntity {

    @Id
    private Long projectSeq;    // 프로젝트 시퀀스 번호

    private String projectTitle;    // 프로젝트 제목

    private String projectContent;  // 프로젝트 내용

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus = ProjectStatus.PROGRESS;   // 프로젝트 상태 PROGRESS(진행중), END(끝)

    private int projectHeadCount;          // 프로젝트 진행 인원 수

    private String projectImgUrl;           // 프로젝트 썸네일 이미지 Url

    private LocalDateTime projectStartDate;     // 프로젝트 시작 날짜

    private LocalDateTime projectEndDate;       // 프로젝트 종료 날짜

    private Long projectAdminUser;          // 프로젝트 작성자 (관리자)

    @Builder
    public Project(String projectTitle, String projectContent, ProjectStatus projectStatus, int projectHeadCount, String projectImgUrl, LocalDateTime projectStartDate, LocalDateTime projectEndDate, User user) {
        super();

    }
}
