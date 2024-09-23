package sansam.team.team.command.application.service.teamBuilding;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sansam.team.project.command.domain.aggregate.entity.ProjectApplyMember;
import sansam.team.team.command.domain.aggregate.entity.Team;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamBuildingService {
//
    public int calculateCommitScore(ProjectApplyMember pjMember) {
        // GitHub 커밋 점수 계산 로직
    }

    public int calculateMajorScore(ProjectApplyMember pjMember) {
        // 전공 점수 계산 로직
    }

    public int calculateCareerScore(ProjectApplyMember pjMember) {
        // 경력 점수 계산 로직
    }

    public int calculateTotalScore(ProjectApplyMember pjMember) {
        int commitScore = calculateCommitScore(pjMember);
        int majorScore = calculateMajorScore(pjMember);
        int careerScore = calculateCareerScore(pjMember);
        return commitScore + majorScore + careerScore;
    }

    public List<Team> buildBalancedTeams(List<ProjectApplyMember> pjMember) {
        // 팀 빌딩 로직
        // 점수 고려 항목들 => 커밋이력, 전공점수, 경력 점수, 팀원 평가, 강사 평가
        // 점수 외 고려 항목들 => 팀 개수, 분야 인원 -> 먼저 고려되어야 함.
    }

    public void assignUserToTeam(ProjectApplyMember pjMember, Team team) {
        // 사용자 팀 할당 로직
    }


    public void saveUserScore(ProjectApplyMember pjMember, int score) {
        // 사용자 점수 저장
    }

    public void saveTeam(Team team) {
        // 팀 정보 저장
    }

   /* public boolean validateUserData(ProjectApplyMember pjMember) {
        // 사용자 데이터 검증 로직
    }*/

    public void logTeamBuildingProcess(ProjectApplyMember pjMember) {
        // 팀 빌딩 과정 로깅
    }
}

