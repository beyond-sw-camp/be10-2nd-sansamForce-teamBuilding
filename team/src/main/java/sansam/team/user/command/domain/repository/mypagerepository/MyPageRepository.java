package sansam.team.user.command.domain.repository.mypagerepository;


import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.user.command.domain.aggregate.entity.User;

import java.util.Optional;

public interface MyPageRepository  {

    Optional<User> findById(Long userSeq);
}
