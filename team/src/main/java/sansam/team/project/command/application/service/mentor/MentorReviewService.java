package sansam.team.project.command.application.service.mentor;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sansam.team.common.jwt.SecurityUtil;
import sansam.team.project.command.application.dto.mentor.MentorReviewDTO;
import sansam.team.project.command.domain.aggregate.entity.MentorReview;
import sansam.team.project.command.domain.repository.mentor.MentorReviewRepository;
import sansam.team.user.command.domain.aggregate.entity.User;

@Service
@RequiredArgsConstructor
public class MentorReviewService {

    private final MentorReviewRepository mentorReviewRepository;
    private final ModelMapper modelMapper;

    /* 멘토 평가 생성 로직 */
    @Transactional
    public MentorReview createMentorReview(Long userSeq, MentorReviewDTO mentorReviewDTO){

        User mentor = SecurityUtil.getAuthenticatedUser();

        if(mentor.getUserSeq() == null){
            throw new IllegalArgumentException("User Seq is null");
        }

        MentorReview mentorReview = modelMapper.map(mentorReviewDTO, MentorReview.class);
        mentorReview.projectMentorSeq(mentor.getUserSeq());
        mentorReview.projectUserSeq(userSeq);

        mentorReviewRepository.save(mentorReview);

        return mentorReview;
    }
}
