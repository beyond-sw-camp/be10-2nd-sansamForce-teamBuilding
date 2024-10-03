package com.sansam.project.command.application.dto;

import com.sansam.project.command.domain.aggregate.ApplyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminProjectApplyMemberDTO {

    private Long projectBoardSeq;
    private ApplyStatus applyStatus;
}