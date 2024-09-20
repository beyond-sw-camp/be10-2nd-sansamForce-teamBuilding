package sansam.team.project.command.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.BaseTimeEntity;

import sansam.team.project.command.enums.ApplyStatus;
import sansam.team.user.command.entity.User;

@Entity
@Table(name = "tbl_project_apply_member")
@Getter
@NoArgsConstructor
public class ProjectApplyMember extends BaseTimeEntity {

    @Id
    private Long projectApplyMemberSeq;                 // 프로젝트 신청 테이블 번호

    @Enumerated(EnumType.STRING)
    private ApplyStatus projectApplyMemberStatus = ApplyStatus.APPLIED;     // 프로젝트 신청 회원 상태 (신청, 허가, 거부)

    private Long userSeq;                               // 프로젝트 신청 회원 번호

    private Long projectBoardSeq;                       // 프로젝트 게시글 번호

    @Builder
    public ProjectApplyMember(ApplyStatus applyStatus, User user, ProjectBoard projectBoard) {
        super();
    }
}
