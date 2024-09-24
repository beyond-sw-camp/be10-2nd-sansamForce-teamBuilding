package sansam.team.exception.aggregate;

public class UserNotFoundException extends Exception{

    private UserNotFoundException(String msg) {
        super(msg);
    }
}
