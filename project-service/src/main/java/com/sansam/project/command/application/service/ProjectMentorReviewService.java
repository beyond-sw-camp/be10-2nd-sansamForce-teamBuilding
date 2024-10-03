package com.sansam.project.command.application.service;

import com.sansam.project.command.application.dto.ProjectMentorReviewCreateDTO;
import com.sansam.project.command.application.dto.ProjectMentorReviewUpdateDTO;
import com.sansam.project.command.domain.aggregate.entity.MentorReview;
import com.sansam.project.command.domain.aggregate.entity.ProjectMember;
import com.sansam.project.command.domain.repository.ProjectMemberRepository;
import com.sansam.project.command.domain.repository.ProjectMentorReviewRepository;
import com.sansam.project.command.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProjectMentorReviewService {

    private final ProjectMentorReviewRepository projectMentorReviewRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ModelMapper modelMapper;

    /* 멘토 평가 생성 로직 */
    @Transactional
    public MentorReview createMentorReview(ProjectMentorReviewCreateDTO projectMentorReviewCreateDTO){

        CustomUserDTO mentor = SecurityUtil.getAuthenticatedUser(); // 인증된 멘토 가져오기

        if(ObjectUtils.isEmpty(mentor.getUserSeq())){
            throw new IllegalArgumentException("User Seq is null");
        }

        // ProjectMemberSeq로 프로젝트 회원을 조회
        ProjectMember projectMember = projectMemberRepository.findById(projectMentorReviewCreateDTO.getProjectMemberSeq())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ProjectMemberSeq"));

        // MentorReview 엔티티 생성 및 값 설정
        MentorReview mentorReview = modelMapper.map(projectMentorReviewCreateDTO, MentorReview.class);
        mentorReview.projectMentorSeq(mentor.getUserSeq()); // 멘토 번호 설정
        mentorReview.projectUserSeq(projectMember.getProjectMemberSeq()); // 프로젝트 회원 번호 설정

        // 멘토 평가 저장
        projectMentorReviewRepository.save(mentorReview);

        return mentorReview;
    }

    /* 멘토 평가 수정 로직 */
    @Transactional
    public MentorReview updateMentorReview(Long mentorReviewSeq, ProjectMentorReviewUpdateDTO projectMentorReviewUpdateDTO){

        MentorReview mentorReview = projectMentorReviewRepository.findById(mentorReviewSeq)
                .orElseThrow(() -> new IllegalArgumentException("Mentor review not found for the given ProjectMemberSeq"));

        mentorReview.updateMentorReview(projectMentorReviewUpdateDTO);

        return mentorReview;
    }

    /* 멘토 평가 삭제 로직 */
    @Transactional
    public void deleteMentorReview(Long mentorReviewSeq) {
        // projectMemberSeq로 멘토 평가 조회
        MentorReview mentorReview = projectMentorReviewRepository.findById(mentorReviewSeq)
                .orElseThrow(() -> new IllegalArgumentException("Mentor review not found for the given ProjectMemberSeq"));

        // 멘토 평가 삭제
        projectMentorReviewRepository.delete(mentorReview);
    }

}