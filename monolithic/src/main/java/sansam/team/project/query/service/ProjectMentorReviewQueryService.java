package sansam.team.project.query.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.query.dto.ProjectMentorReviewAllQueryDTO;
import sansam.team.project.query.dto.ProjectMentorReviewAllUserQueryDTO;
import sansam.team.project.query.dto.ProjectMentorReviewQueryDTO;
import sansam.team.project.query.dto.ProjectMentorReviewUserQueryDTO;
import sansam.team.project.query.mapper.ProjectMentorReviewMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMentorReviewQueryService {

    private final ProjectMentorReviewMapper projectMentorReviewMapper;

    /* 강사 - 프로젝트 내 회원 평가한 내용 전체 조회 */
    public List<ProjectMentorReviewAllQueryDTO> getAllProjectMentorReview(){
        return projectMentorReviewMapper.findAllForMentor();
    }

    /* 강사 - 프로젝트 내 회원 평가한 내용 상세 조회 */
    public ProjectMentorReviewQueryDTO getProjectMentorReviewByIdForMentor(Long mentorReviewSeq){
        return projectMentorReviewMapper.findByIdForMentor(mentorReviewSeq);
    }

    /* 회원 - 프로젝트 내 강사 평가 전체 조회*/
    public List<ProjectMentorReviewAllUserQueryDTO> getProjectMentorReviewAllByIdForUser(){
        return projectMentorReviewMapper.findAllByIdForUser();
    }

    /* 회원 - 프로젝트 내 강사 평가 상세 조회*/
    public ProjectMentorReviewUserQueryDTO getProjectMentorReviewByIdForUser(Long mentorReviewSeq){
        return projectMentorReviewMapper.findByIdForUser(mentorReviewSeq);
    }
}
