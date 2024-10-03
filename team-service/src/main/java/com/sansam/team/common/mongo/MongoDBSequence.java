package com.sansam.team.common.mongo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class MongoDBSequence {
    private String id;
    private Long seq;
}