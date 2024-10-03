package com.sansam.project.command.domain.aggregate.entity;

import com.sansam.project.command.application.dto.AdminProjectApplyMemberDTO;
import com.sansam.project.command.domain.aggregate.ApplyStatus;
import com.sansam.project.common.aggregate.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_project_apply_member")
@Getter
@NoArgsConstructor
public class ProjectApplyMember extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectApplyMemberSeq;                 // 프로젝트 신청 테이블 번호

    @Enumerated(EnumType.STRING)
    private ApplyStatus projectApplyMemberStatus = ApplyStatus.APPLIED;     // 프로젝트 신청 회원 상태 (신청, 허가, 거부)

    private Long userSeq;                               // 프로젝트 신청 회원 번호

    private Long projectBoardSeq;                       // 프로젝트 게시글 번호

    private ProjectApplyMember(ApplyStatus applyStatus, Long userSeq, Long projectBoardSeq) {
        this.projectApplyMemberStatus = applyStatus;
        this.userSeq = userSeq;
        this.projectBoardSeq = projectBoardSeq;
    }

    public static ProjectApplyMember createEntity(ApplyStatus applyStatus, Long userSeq, Long projectBoardSeq) {
        return new ProjectApplyMember(applyStatus, userSeq, projectBoardSeq);
    }

    public void modifyApplyMemberStatus(Long projectBoardSeq, AdminProjectApplyMemberDTO adminProjectApplyMemberDTO) {
        this.projectBoardSeq = projectBoardSeq;
        this.projectApplyMemberStatus = adminProjectApplyMemberDTO.getApplyStatus();
    }
}