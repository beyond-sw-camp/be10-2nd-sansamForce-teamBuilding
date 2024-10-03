package com.sansam.project.query.dto;


import com.sansam.project.common.aggregate.DevelopType;
import com.sansam.project.common.aggregate.YnType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminProjectMemberAllQueryDTO {

    private Long userSeq;
    private String userName;
    private YnType projectMemberDelYn;
    private YnType projectMentorYn;
    private YnType projectMemberMajorYn;
    private DevelopType projectMemberDevelopType;
    private Long projectMemberCommitScore;
}