package sansam.team.project.command.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Auditable;
import sansam.team.common.BaseTimeEntity;
import sansam.team.project.command.enums.BoardStatus;
import sansam.team.user.command.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_project_board")
@Getter
@NoArgsConstructor
public class ProjectBoard extends BaseTimeEntity {

    @Id
    private Long projectBoardSeq;

    private String projectBoardTitle;

    private String projectBoardContent;

    private int projectBoardHeadCount;

    private String projectBoardImgUrl;

    private LocalDateTime projectBoardStartDate;

    private LocalDateTime projectBoardEndDate;

    @Enumerated(EnumType.STRING)
    private BoardStatus boardStatus = BoardStatus.RECRUITMENT;

    private LocalDateTime projectStartDate;

    private LocalDateTime projectEndDate;

    private Long projectBoardAdminSeq;

    @Builder
    public ProjectBoard(String projectBoardTitle, String projectBoardContent, int projectBoardHeadCount, String projectBoardImgUrl, LocalDateTime projectBoardStartDate, LocalDateTime projectBoardEndDate, BoardStatus boardStatus, LocalDateTime projectStartDate, LocalDateTime projectEndDate, User user) {
        super();
    }
}
