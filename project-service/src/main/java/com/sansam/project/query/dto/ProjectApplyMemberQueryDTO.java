package com.sansam.project.query.dto;


import com.sansam.project.command.domain.aggregate.ApplyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectApplyMemberQueryDTO {

    private Long userSeq;          // 사용자 ID
    private String userName;       // 사용자 이름
    private String userNickname;   // 사용자 닉네임
    private ApplyStatus applyStatus; // 신청 상태
}