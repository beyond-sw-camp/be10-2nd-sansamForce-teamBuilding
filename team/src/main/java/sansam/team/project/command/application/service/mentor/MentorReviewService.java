package sansam.team.project.command.application.service.mentor;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sansam.team.common.jwt.SecurityUtil;
import sansam.team.project.command.application.dto.mentor.MentorReviewCreateDTO;
import sansam.team.project.command.application.dto.mentor.MentorReviewUpdateDTO;
import sansam.team.project.command.domain.aggregate.entity.MentorReview;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;
import sansam.team.project.command.domain.repository.mentor.MentorReviewRepository;
import sansam.team.project.command.domain.repository.project.ProjectMemberRepository;
import sansam.team.project.command.domain.repository.project.ProjectRepository;
import sansam.team.user.command.domain.aggregate.entity.User;

@Service
@RequiredArgsConstructor
public class MentorReviewService {

    private final MentorReviewRepository mentorReviewRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final ModelMapper modelMapper;

    /* 멘토 평가 생성 로직 */
    @Transactional
    public MentorReview createMentorReview(MentorReviewCreateDTO mentorReviewCreateDTO){

        User mentor = SecurityUtil.getAuthenticatedUser(); // 인증된 멘토 가져오기

        if(mentor.getUserSeq() == null){
            throw new IllegalArgumentException("Mentor user sequence is null");
        }

        // ProjectMemberSeq로 프로젝트 회원을 조회
        ProjectMember projectMember = projectMemberRepository.findById(mentorReviewCreateDTO.getProjectMemberSeq())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ProjectMemberSeq"));

        // MentorReview 엔티티 생성 및 값 설정
        MentorReview mentorReview = modelMapper.map(mentorReviewCreateDTO, MentorReview.class);
        mentorReview.projectMentorSeq(mentor.getUserSeq()); // 멘토 번호 설정
        mentorReview.projectUserSeq(projectMember.getProjectMemberSeq()); // 프로젝트 회원 번호 설정

        // 멘토 평가 저장
        mentorReviewRepository.save(mentorReview);

        return mentorReview;
    }

    /* 멘토 평가 수정 로직 */
    @Transactional
    public MentorReview updateMentorReview(Long mentorReviewSeq, MentorReviewUpdateDTO mentorReviewUpdateDTO){

        MentorReview mentorReview = mentorReviewRepository.findById(mentorReviewSeq)
                .orElseThrow(() -> new IllegalArgumentException("Mentor review not found for the given ProjectMemberSeq"));

        mentorReview.updateMentorReview(mentorReviewUpdateDTO);

        return mentorReview;
    }

    /* 멘토 평가 삭제 로직 */
    @Transactional
    public void deleteMentorReview(Long mentorReviewSeq) {
        // projectMemberSeq로 멘토 평가 조회
        MentorReview mentorReview = mentorReviewRepository.findById(mentorReviewSeq)
                .orElseThrow(() -> new IllegalArgumentException("Mentor review not found for the given ProjectMemberSeq"));

        // 멘토 평가 삭제
        mentorReviewRepository.delete(mentorReview);
    }

}
