package sansam.team.team.command.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.common.aggregate.YnType;
import sansam.team.project.command.domain.aggregate.InterestType;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.project.command.domain.aggregate.entity.ProjectMember;
import sansam.team.project.command.domain.repository.project.ProjectMemberRepository;
import sansam.team.team.command.application.dto.TeamBuildingDTO;
import sansam.team.team.command.domain.aggregate.entity.Team;
import sansam.team.team.command.domain.repository.TeamMemberRepository;
import sansam.team.team.command.domain.repository.TeamRepository;
import sansam.team.user.command.domain.aggregate.entity.User;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TeamBuildingService {

    private final ProjectMemberRepository projectMemberRepository;
    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;

    //
    public int calculateCommitScore(TeamBuildingDTO teamBuildingDTO) {

        return 0;
        // GitHub 커밋 점수 계산 로직
    }

    public int calculateMajorScore(ProjectMember pjMember) {
        return pjMember.getProjectMemberMajorYn()== YnType.Y?5:0;
        // 전공 점수 계산 로직 (완)
    }
/*
    public int calculateCareerScore(ProjectApplyMember pjMember) {
        // 경력 점수 계산 로직 (이거 왜 없지)
    }*/

    public int calculateTotalScore(TeamBuildingDTO teamBuildingDTO) {
        int commitScore = calculateCommitScore(teamBuildingDTO);
        ProjectMember pjMember = (teamBuildingDTO.getProjectMemberSeq())
        int majorScore = calculateMajorScore(teamBuildingDTO.);
      //  int careerScore = calculateCareerScore(pjMember);
        return commitScore + majorScore;
    }

    public List<Team> buildBalancedTeams(Long projectSeq, Long teamBuildingRuleSeq) {
        //1. 해당 프로젝트 참여자 List 불러오기
        Optional<ProjectMember> optionalProjectMember = projectMemberRepository.findById(projectSeq);
        // Optional을 List로 변환
        List<ProjectMember> projectMembers = optionalProjectMember
                .map(Collections::singletonList) // 값이 있을 때 그 값을 포함한 리스트 반환
                .orElseGet(Collections::emptyList); // 값이 없으면 빈 리스트 반환

        //2. 프로젝트 참여자들을 관심 분야에 따라 분류
        List<ProjectMember> frontMembers = new ArrayList<>();
        List<ProjectMember> backMembers = new ArrayList<>();

        for(ProjectMember pjMember : projectMembers) {
            if(pjMember.getProjectMemberInterestType().equals(InterestType.FRONTEND)) {
                frontMembers.add(pjMember);
            }
            else if(pjMember.getProjectMemberInterestType().equals(InterestType.BACKEND)) {
                backMembers.add(pjMember);
            }
        }
        //3. 팀 빌딩 규칙의 팀 개수에 따라 정하기. 지금은 편의상 5로.
        int teamCnt = 5;

        //4. 팀 만들기
        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < teamCnt; i++) {
            Team newTeam = Team.create(projectSeq,0,i+1+"조"); // Create a new team entity
            teamRepository.save(newTeam);
            teams.add(newTeam);
        }

        // 5. 프로젝트 참여자 점수에 따라 정렬해 팀원 추가하기.

        return null;
    }

}

