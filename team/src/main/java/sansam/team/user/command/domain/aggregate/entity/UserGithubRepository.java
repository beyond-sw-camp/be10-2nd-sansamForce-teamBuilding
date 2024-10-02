package sansam.team.user.command.domain.aggregate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.DevelopType;
import sansam.team.user.command.domain.aggregate.StatusType;

@Builder
@Entity
@Table(name = "tbl_user_github_repository")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserGithubRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userRepositorySeq;

    private String userRepositoryUrl;

    private String userRepositoryName;

    @Enumerated(EnumType.STRING)
    private DevelopType developType;

    private Long userSeq;

    public UserGithubRepository(String userRepositoryUrl, String userRepositoryName, DevelopType developType, Long userSeq) {
        this.userRepositoryUrl = userRepositoryUrl;
        this.userRepositoryName = userRepositoryName;
        this.developType = developType;
        this.userSeq = userSeq;
    }

    public static UserGithubRepository create(String userRepositoryUrl, String userRepositoryName, DevelopType developType, Long userSeq) {
        return new UserGithubRepository(userRepositoryUrl,userRepositoryName,developType,userSeq);
    }


    public void modifyUserGithubRepository(String userRepositoryUrl,
                                           String userRepositoryName,
                                           DevelopType developType) {
        this.userRepositoryUrl = userRepositoryUrl;
        this.userRepositoryName = userRepositoryName;
        this.developType = developType;
    }
}
