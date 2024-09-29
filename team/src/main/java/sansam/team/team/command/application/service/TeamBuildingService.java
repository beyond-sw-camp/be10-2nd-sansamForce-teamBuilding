package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sansam.team.common.aggregate.YnType;
import sansam.team.common.github.GithubUtil;
import sansam.team.project.command.application.dto.project.ProjectMemberUpdateDTO;
import sansam.team.project.command.domain.aggregate.InterestType;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;
import sansam.team.project.command.domain.repository.project.ProjectMemberRepository;
import sansam.team.team.command.application.dto.TeamBuildingDTO;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.aggregate.entity.TeamMember;
import sansam.team.team.command.domain.aggregate.entity.TeamReview;
import sansam.team.team.command.domain.repository.TeamMemberRepository;
import sansam.team.team.command.domain.repository.TeamRepository;
import sansam.team.team.command.domain.repository.TeamReviewRepository;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.command.domain.repository.UserRepository;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamBuildingService {

    private final UserRepository userRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final TeamRepository teamRepository;
    private final GithubUtil githubUtil;
    private final TeamReviewRepository teamReviewRepository;
    private final TeamMemberRepository teamMemberRepository;

    // 1. 깃허브 커밋 점수 계산 로직
    public long calculateCommitScore(TeamBuildingDTO teamBuildingDTO) throws IOException {
        User user = userRepository.findById(teamBuildingDTO.getUserSeq())
                .orElseThrow(() -> new RuntimeException("User does not exist"));

        ProjectMember pjMember = projectMemberRepository.findById(teamBuildingDTO.getProjectMemberSeq())
                .orElseThrow(() -> new RuntimeException("Project Member does not exist"));

        int commitCnt = githubUtil.getCommitCountByInterestType(user.getUserGithubId(),pjMember.getProjectMemberInterestType());

        // GitHub 커밋 점수 계산 로직
        long commitScore;
        if(commitCnt < 100){
            commitScore = 0L;
        }
        else if(commitCnt < 300){
            commitScore = 1L;
        }
        else if(commitCnt < 500){
            commitScore = 2L;
        }
        else if(commitCnt < 700){
            commitScore = 3L;
        }
        else if(commitCnt < 900){
            commitScore = 4L;
        }
        else{
            commitScore = 5L;
        }

        //pjMember commitScore 업데이트
        ProjectMemberUpdateDTO pjMemberUpdateDTO = new ProjectMemberUpdateDTO();
        pjMemberUpdateDTO.setProjectMemberCommitScore(commitScore);
        pjMember.modifyProjectMember(pjMemberUpdateDTO);

        return commitScore;
    }

    // 2. 전공 점수 계산 로직
    public int calculateMajorScore(TeamBuildingDTO teamBuildingDTO) throws IOException {
        ProjectMember pjMember = projectMemberRepository.findById(teamBuildingDTO.getProjectMemberSeq())
                .orElseThrow(() -> new RuntimeException("Project Member does not exist"));
        return pjMember.getProjectMemberMajorYn()== YnType.Y?5:0;

    }
    /*
    // 3. 경력 점수 계산 로직 (컬럼 추가해야함)
    public int calculateCareerScore(ProjectApplyMember pjMember) {

    }*/

    // 4. 팀원 평가 점수 계산 로직
    public double calculateTeamEvaluation(TeamBuildingDTO teamBuildingDTO) throws IOException {
        List<TeamReview> reviews = teamReviewRepository.findAllByReceiveMemberSeq(teamBuildingDTO.getUserSeq())
                .map(Collections::singletonList)
                .orElseGet(Collections::emptyList);

        double totalEvaluation = 0;

        if (reviews.isEmpty()) {
            return 3.0; // 평가가 없을 경우 3.0점 반환
        }

        for(TeamReview teamReview: reviews){
            totalEvaluation += teamReview.getReviewStar();
        }
        return totalEvaluation/reviews.size();

    }
    //5. 강사 평가 점수 계산 로직
    /*
    public double calculateMentorEvaluation(TeamBuildingDTO teamBuildingDTO) throws IOException{

    }
    * */


    // 팀 빌딩 점수 합 구하기.
    public double calculateTotalScore(TeamBuildingDTO teamBuildingDTO) throws IOException {
        //
        long commitScore = calculateCommitScore(teamBuildingDTO);
        int majorScore = calculateMajorScore(teamBuildingDTO);
        double teamEvaluationScore = calculateTeamEvaluation(teamBuildingDTO);
        return commitScore + majorScore + teamEvaluationScore;
    }
    //팀 빌딩 로직 -> 팀 빌딩 규칙 추가해야함
    @Transactional
    public List<Team> buildBalancedTeams(Long projectSeq /*, Long buildingRuleSeq */) throws IOException {

        //1. 해당 프로젝트 참여자 List 불러오기
        List<ProjectMember> projectMembers = projectMemberRepository.findAllByProjectSeq(projectSeq);

        //2. 프로젝트 참여자들을 관심 분야에 따라 분류
        List<TeamBuildingDTO> frontMembers = new ArrayList<>();
        List<TeamBuildingDTO> backMembers = new ArrayList<>();

        for (ProjectMember pjMember : projectMembers) {
            Long userSeq = pjMember.getUserSeq();
            TeamBuildingDTO teamBuildingDTO = new TeamBuildingDTO(userSeq,pjMember.getProjectMemberSeq());
            double totalScore = calculateTotalScore(teamBuildingDTO);
            teamBuildingDTO.setTotalScore(totalScore);

            if (pjMember.getProjectMemberInterestType().equals(InterestType.FRONTEND)) {
                frontMembers.add(teamBuildingDTO);
            } else if (pjMember.getProjectMemberInterestType().equals(InterestType.BACKEND)) {
                backMembers.add(teamBuildingDTO);
            }
        }
        //3. 팀 빌딩 규칙의 팀 개수에 따라 정하기 (지금은 편의상 5로)
        int teamCnt = 5;


        //4. 팀 만들기
        List<Team> teams = new ArrayList<>();


        Map<Team, Double> teamTotalScores = new HashMap<>();
        Map<Team,Long> teamMemberCnt = new HashMap<>();

        for (int i = 0; i < teamCnt; i++) {
            Team newTeam = Team.create(projectSeq, 1, i + 1 + "조");
            teamRepository.save(newTeam);
            teams.add(newTeam);
            teamTotalScores.put(newTeam,0.0);
            teamMemberCnt.put(newTeam,0L);
            log.info(newTeam.toString());
        }

        // 5. 프로젝트 참여자 점수에 따라 정렬해 팀원 추가하기.
        frontMembers.sort(Comparator.comparingDouble(TeamBuildingDTO::getTotalScore)); ;
        backMembers.sort(Comparator.comparingDouble(TeamBuildingDTO::getTotalScore));

        // 6. 팀원 분배
        assignMembersToTeams(frontMembers, teamTotalScores, teamMemberCnt);
        assignMembersToTeams(backMembers, teamTotalScores, teamMemberCnt);

        return teams;
    }

    public void assignMembersToTeams(List<TeamBuildingDTO> members, Map<Team, Double> teamTotalScores, Map<Team, Long> teamMemberCnt) {
        for (TeamBuildingDTO member : members) {
            // 1. 인원수가 가장 적은 팀 -> 점수 작은 팀 순으로 선택
            Team targetTeam = findTargetTeam(teamTotalScores,teamMemberCnt);

            TeamMember teamMember = new TeamMember(member.getUserSeq(),targetTeam.getTeamSeq());

            teamMemberRepository.save(teamMember);

            double updatedScore = teamTotalScores.get(targetTeam) + member.getTotalScore();
            teamTotalScores.put(targetTeam, updatedScore);
            teamMemberCnt.put(targetTeam, teamMemberCnt.get(targetTeam)+1);
        }
    }

    public Team findTargetTeam(Map<Team, Double> teamTotalScores, Map<Team, Long> teamMemberCnt) {
        return teamTotalScores.keySet().stream()
                .min(Comparator.comparingLong(teamMemberCnt::get)
                        .thenComparingDouble(teamTotalScores::get))
                .orElseThrow(() -> new NoSuchElementException("팀이 존재하지 않습니다."));
    }

}

