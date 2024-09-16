package sansam.team.project.command.enums;

public enum BoardStatus {
    RECRUITMENT("모집"),
    DEADLINE("마감"),
    DELETE("삭제");

    private final String status;

    BoardStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

}
