package sansam.team.user.command.domain.repository.mypagerepository;


import org.springframework.data.jpa.repository.JpaRepository;
import sansam.team.user.command.domain.aggregate.entity.User;

public interface MyPageRepository extends JpaRepository<User, Long> {

}
