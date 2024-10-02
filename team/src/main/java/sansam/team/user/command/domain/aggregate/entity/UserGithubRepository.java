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

    private Long userSeq;

    private String userRepositoryUrl;

    private String userRepositoryName;

    @Enumerated(EnumType.STRING)
    private DevelopType developType;


    public UserGithubRepository(Long userSeq, String userRepositoryUrl, String userRepositoryName, DevelopType developType) {
        this.userSeq = userSeq;
        this.userRepositoryUrl = userRepositoryUrl;
        this.userRepositoryName = userRepositoryName;
        this.developType = developType;
    }

    public static UserGithubRepository create(Long userSeq,String userRepositoryUrl, String userRepositoryName, DevelopType developType ) {
        return new UserGithubRepository(userSeq,userRepositoryUrl,userRepositoryName,developType);
    }


    public void modifyUserGithubRepository(String userRepositoryUrl,
                                           String userRepositoryName,
                                           DevelopType developType) {
        this.userRepositoryUrl = userRepositoryUrl;
        this.userRepositoryName = userRepositoryName;
        this.developType = developType;
    }
}
