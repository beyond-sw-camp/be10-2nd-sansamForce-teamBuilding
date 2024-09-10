package sansam.team.test.query.mappers;

import org.apache.ibatis.annotations.Mapper;
import sansam.team.test.command.services.TestDTO;

import java.util.List;

@Mapper
public interface TestMapper {
    List<TestDTO> findAllTests();

    TestDTO findTestById(Long id);
}