package sansam.team.major.command.domain.aggregate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sansam.team.common.aggregate.entity.BaseTimeEntity;
import sansam.team.major.command.application.dto.MajorDTO;

@Entity
@Getter
@Table(name = "tbl_major")
@NoArgsConstructor
public class Major extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long majorSeq;
    private String majorUniversity;
    private String majorDepartment;
    private String majorDepartmentCode;

    public void updateFrom(MajorDTO dto) {
        this.majorUniversity = dto.getMajorUniversity();
        this.majorDepartment = dto.getMajorDepartment();
        this.majorDepartmentCode = dto.getMajorDepartmentCode();
    }
}
