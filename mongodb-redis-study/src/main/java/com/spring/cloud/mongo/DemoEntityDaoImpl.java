package com.spring.cloud.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class DemoEntityDaoImpl implements IDemoEntityDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(DemoEntity demoEntity) {
        mongoTemplate.save(demoEntity);
    }

    @Override
    public void delete(DemoEntity demoEntity) {
        mongoTemplate.remove(demoEntity);
    }

    @Override
    public void update(DemoEntity demoEntity) {
        Query query = new Query(Criteria.where("id").is(demoEntity.getId()));
        Update update = new Update();
        update.set("count", demoEntity.getCount());
        update.set("sum", demoEntity.getSum());
        update.set("memo", demoEntity.getMemo());
        mongoTemplate.updateFirst(query, update, DemoEntity.class);
    }

    @Override
    public DemoEntity findOneById(Long id) {
        return mongoTemplate.findById(id, DemoEntity.class);
    }
}
