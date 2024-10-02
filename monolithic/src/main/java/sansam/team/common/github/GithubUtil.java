package sansam.team.common.github;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.kohsuke.github.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Getter
@Slf4j
@Component
public class GithubUtil {
    private final GitHub github;

    public GithubUtil(@Value("${github.token}") String token) throws IOException {
        this.github = new GitHubBuilder().withOAuthToken(token).build();
        this.github.checkApiUrlValidity();
    }


    public int getCommitCountFromRepoUrl(String userGithubId, String repoUrl) throws IOException {
        // 레포지토리 이름 추출 (organization/repository)
        String[] urlParts = repoUrl.split("/");
        if (urlParts.length < 5) {
            throw new IllegalArgumentException("잘못된 레포지토리 URL 형식입니다.");
        }

        String orgName = urlParts[3];
        String repoName = urlParts[4];

        // 레포지토리 가져오기
        GHRepository repository = github.getRepository(orgName + "/" + repoName);

        if (repository == null) {
            log.warn("레포지토리 {}를 찾을 수 없습니다.", repoUrl);
            return 0;
        }

        int commitCount = 0;

        try {
            // 사용자의 커밋 이력 가져오기
            PagedIterable<GHCommit> commits = repository.queryCommits().author(userGithubId).list();
            commitCount = (int) commits.toList().size(); // 사용자의 커밋 개수
        } catch (IOException e) {
            log.error("레포지토리 {}에서 커밋을 가져오는 중 오류 발생: {}", repoUrl, e.getMessage());
        }

        log.info("레포지토리 {}에서 사용자 {}의 커밋 개수: {}", repoUrl, userGithubId, commitCount);
        return commitCount;
    }
}
