package com.sansam.user.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.sansam.user", annotationClass = Mapper.class)
public class MybatisConfig {
}
