package com.spring.cloud.mongo;

public interface IDemoEntityDao {

    void save(DemoEntity demoEntity);

    void delete(DemoEntity demoEntity);

    void update(DemoEntity demoEntity);

    DemoEntity findOneById(Long id);
}
