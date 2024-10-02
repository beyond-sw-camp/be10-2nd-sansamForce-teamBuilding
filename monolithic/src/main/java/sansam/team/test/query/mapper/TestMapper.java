package sansam.team.test.query.mapper;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.test.command.dto.TestDTO;

import java.util.List;

@Mapper
public interface TestMapper {
    List<TestDTO> findAllTests();

    TestDTO findTestById(Long id);
}