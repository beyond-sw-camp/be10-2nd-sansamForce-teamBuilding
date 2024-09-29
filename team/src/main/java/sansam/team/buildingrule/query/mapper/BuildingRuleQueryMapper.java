package sansam.team.buildingrule.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.buildingrule.query.dto.BuildingRuleQueryDTO;

import java.util.List;

@Mapper
public interface BuildingRuleQueryMapper {

    BuildingRuleQueryDTO findById(int ruleSeq);

    List<BuildingRuleQueryDTO> findAll();
}
