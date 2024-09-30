package sansam.team.major.query.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MajorQueryDTO {
    private Long majorSeq;
    private String majorUniversity;
    private String majorDepartment;
    private String majorDepartmentCode;
}
