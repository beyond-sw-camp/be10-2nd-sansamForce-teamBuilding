package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.common.aggregate.YnType;
import sansam.team.common.github.GithubUtil;
import sansam.team.project.command.domain.aggregate.InterestType;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;
import sansam.team.project.command.domain.repository.project.ProjectMemberRepository;
import sansam.team.team.command.application.dto.TeamBuildingDTO;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.repository.TeamMemberRepository;
import sansam.team.team.command.domain.repository.TeamRepository;
import sansam.team.user.command.domain.aggregate.entity.User;
import sansam.team.user.command.domain.repository.UserRepository;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class TeamBuildingService {

    private final UserRepository userRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final TeamRepository teamRepository;
    private final GithubUtil githubUtil;

    // 분야 별 깃허브 점수 계산 로직
    public int calculateCommitScore(TeamBuildingDTO teamBuildingDTO) throws IOException {
        User user = userRepository.findById(teamBuildingDTO.getUserSeq())
                .orElseThrow(() -> new RuntimeException("User does not exist"));

        ProjectMember pjMember = projectMemberRepository.findById(teamBuildingDTO.getProjectMemberSeq())
                .orElseThrow(() -> new RuntimeException("Project Member does not exist"));

        int commitCnt = githubUtil.getCommitCountByInterestType(user.getUserGithubId(),pjMember.getProjectMemberInterestType());

        // 프로젝트 멤버의 커밋 점수 저장..?

        // GitHub 커밋 점수 계산 로직
        int commitScore;
        if(commitCnt < 100){
            commitScore = 0;
        }
        else if(commitCnt < 300){
            commitScore = 1;
        }
        else if(commitCnt < 500){
            commitScore = 2;
        }
        else if(commitCnt < 700){
            commitScore = 3;
        }
        else if(commitCnt < 900){
            commitScore = 4;
        }
        else{
            commitScore = 5;
        }
        return commitScore;
    }

    // 전공 점수 계산 로직
    public int calculateMajorScore(TeamBuildingDTO teamBuildingDTO) throws IOException {
        ProjectMember pjMember = projectMemberRepository.findById(teamBuildingDTO.getProjectMemberSeq())
                .orElseThrow(() -> new RuntimeException("Project Member does not exist"));
        return pjMember.getProjectMemberMajorYn()== YnType.Y?5:0;

    }
/*
    public int calculateCareerScore(ProjectApplyMember pjMember) {
        // 경력 점수 계산 로직 (이거 왜 없지........)
    }*/


    // 팀 빌딩 규칙 
    public int calculateTotalScore(TeamBuildingDTO teamBuildingDTO) throws IOException {
        //
        int commitScore = calculateCommitScore(teamBuildingDTO);
        int majorScore = calculateMajorScore(teamBuildingDTO);
      //  int careerScore = calculateCareerScore(pjMember);
        return commitScore + majorScore;
    }

    public List<Team> buildBalancedTeams(Long projectSeq, Long teamBuildingRuleSeq) throws IOException {
        //1. 해당 프로젝트 참여자 List 불러오기
        Optional<ProjectMember> optionalProjectMember = projectMemberRepository.findAllByProjectSeq(projectSeq);

        List<ProjectMember> projectMembers = optionalProjectMember
                .map(Collections::singletonList) // 값이 있을 때 그 값을 포함한 리스트 반환
                .orElseGet(Collections::emptyList); // 값이 없으면 빈 리스트 반환

        //2. 프로젝트 참여자들을 관심 분야에 따라 분류
        List<TeamBuildingDTO> frontMembers = new ArrayList<>();
        List<TeamBuildingDTO> backMembers = new ArrayList<>();

        for (ProjectMember pjMember : projectMembers) {
            Long userSeq = pjMember.getUserSeq();
            TeamBuildingDTO teamBuildingDTO = new TeamBuildingDTO(userSeq,pjMember.getProjectMemberSeq());
            int totalScore = calculateTotalScore(teamBuildingDTO);
            teamBuildingDTO.setTotalScore(totalScore);

            if (pjMember.getProjectMemberInterestType().equals(InterestType.FRONTEND)) {
                frontMembers.add(teamBuildingDTO);
            } else if (pjMember.getProjectMemberInterestType().equals(InterestType.BACKEND)) {
                backMembers.add(teamBuildingDTO);
            }
        }
        //3. 팀 빌딩 규칙의 팀 개수에 따라 정하기. 지금은 편의상 5로.
        int teamCnt = 5;

        //4. 팀 만들기
        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < teamCnt; i++) {
            Team newTeam = Team.create(projectSeq,0,i+1+"조"); //
            teamRepository.save(newTeam);
            teams.add(newTeam);
        }

        // 5. 프로젝트 참여자 점수에 따라 정렬해 팀원 추가하기.

        return null;
    }

}

