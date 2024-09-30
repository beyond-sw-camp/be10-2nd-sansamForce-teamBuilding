package sansam.team.common.github;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sansam.team.project.command.domain.aggregate.InterestType;

import java.io.IOException;
import java.util.*;

@Getter
@Slf4j
@Component
public class GithubUtil {
    private GitHub github;

    public GithubUtil(@Value("${github.token}") String token) throws IOException {
        this.github = new GitHubBuilder().withOAuthToken(token).build();
        this.github.checkApiUrlValidity();
    }

    public int getCommitCountByInterestType(String userGithubId, InterestType interestType) throws IOException {
   //     log.info("커밋 카운트 fetching 유저: {}, 선호 분야: {}", userGithubId, interestType);
        Set<String> languages = getLanguagesByInterestType(interestType);

        int commitCount = 0;

        // 사용자의 모든 리포지토리 가져오기

        PagedIterable<GHRepository> repositories = github.getUser(userGithubId).listRepositories();

        // 리포지토리 확인
        List<GHRepository> repoList = new ArrayList<>();
        repositories.forEach(repo -> {
     //       log.info("찾은 repo: {}", repo.getFullName());
            repoList.add(repo);
        });

        // 리포지토리가 없는 경우 처리
        if (repoList.isEmpty()) {
            log.warn("사용자 {}의 리포지토리 존재 X", userGithubId);
            return commitCount; // 0을 반환하거나 필요에 따라 다른 값을 반환
        }

        for (GHRepository repo : repositories) {
            // 포크된 리포지토리는 제외
            if (repo.isFork()) continue;

            try {
                // 리포지토리의 커밋들 가져오기 (사용자가 작성한 커밋)
                PagedIterable<GHCommit> commits = repo.queryCommits().author(userGithubId).list();

                for (GHCommit commit : commits) {
                    // 커밋의 파일들 가져오기
                    List<GHCommit.File> files = commit.getFiles();

                    // 해당 커밋에서 역할에 맞는 언어의 파일이 수정되었는지 확인
                    boolean hasRelevantFile = files.stream().anyMatch(file -> {
                        String extension = getFileExtension(file.getFileName());
                        String language = getLanguageByExtension(extension);
                        return languages.contains(language);
                    });

                    if (hasRelevantFile) {
                        commitCount++;
                    }
                }
            } catch (GHException e) {
                // Git Repository가 비어있거나 다른 에러 발생 시 로깅
                if (e.getMessage().contains("Git Repository is empty.")) {
                    log.warn("리포지토리 {}는 비어있음.", repo.getFullName());
                } else {
                    log.error("리포지토리 {}에서 커밋을 가져오는 중 오류 발생: {}", repo.getFullName(), e.getMessage());
                }
            }
        }
       // log.info("커밋 개수 = {}", commitCount);
        return commitCount;
    }

    // 분야에 따른 언어 세트 반환
    private Set<String> getLanguagesByInterestType(InterestType interestType) {
        if(interestType.equals(InterestType.BACKEND)){
            return new HashSet<>(Arrays.asList("Python", "Java", "Kotlin", "Go", "Rust", "C#", "C++"));
        }
        else if (interestType.equals(InterestType.FRONTEND)) {
            return new HashSet<>(Arrays.asList("HTML", "CSS", "JavaScript"));
        } else {
            return Collections.emptySet();
        }
    }

    // 파일 확장자로부터 언어를 추론
    private String getLanguageByExtension(String extension) {
        switch (extension.toLowerCase()) {
            case "py":
                return "Python";
            case "java":
                return "Java";
            case "kt":
            case "kts":
                return "Kotlin";
            case "go":
                return "Go";
            case "rs":
                return "Rust";
            case "cs":
                return "C#";
            case "cpp":
            case "cxx":
            case "cc":
            case "c":
                return "C++";
            case "html":
            case "htm":
                return "HTML";
            case "css":
                return "CSS";
            case "js":
            case "jsx":
                return "JavaScript";
            default:
                return "";
        }
    }

    // 파일 이름에서 확장자 추출
    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) return "";
        return fileName.substring(lastDotIndex + 1);
    }


}
