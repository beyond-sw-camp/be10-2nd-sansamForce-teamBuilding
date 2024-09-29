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
        log.info("GitHub API 연결 성공: {}", token);
    }

    public int getCommitCountByInterestType(String userGithubId, InterestType interestType) throws IOException {
        Set<String> languages = getLanguagesByInterestType(interestType);

        int commitCount = 0;

        // 사용자의 모든 리포지토리 가져오기
        PagedIterable<GHRepository> repositories = github.getUser(userGithubId).listRepositories();

        for (GHRepository repo : repositories) {
            // 포크된 리포지토리는 제외
            if (repo.isFork()) continue;

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
        }

        return commitCount;
    }

    // 역할에 따른 언어 세트 반환
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
