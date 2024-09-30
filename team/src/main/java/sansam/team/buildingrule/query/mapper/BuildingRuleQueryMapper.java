package sansam.team.buildingrule.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.buildingrule.query.dto.BuildingRuleQueryDTO;

import java.util.List;

@Mapper
public interface BuildingRuleQueryMapper {

    BuildingRuleQueryDTO findById(long ruleSeq);

    List<BuildingRuleQueryDTO> findAll();
}
