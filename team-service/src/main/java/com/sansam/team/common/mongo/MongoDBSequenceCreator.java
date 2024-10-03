package com.sansam.team.common.mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MongoDBSequenceCreator {

    private final MongoTemplate mongoTemplate;

    public Long createSeq(String sequenceName) {
        Query query = new Query(Criteria.where("_id").is(sequenceName));
        Update update = new Update().inc("seq", 1);
        FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(true).upsert(true);

        MongoDBSequence seq = mongoTemplate.findAndModify(query, update, options, MongoDBSequence.class);

        return seq.getSeq();
    }
}
