package com.spring.cloud.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/demo")
public class DemoEntityController {

    @Autowired
    private IDemoEntityDao demoEntityDao;

    @PostMapping(value = "save")
    public void save(@RequestBody DemoEntity demoEntity) {
        demoEntityDao.save(demoEntity);
    }

    @PostMapping(value = "update")
    public void update(@RequestBody DemoEntity demoEntity) {
        demoEntityDao.update(demoEntity);
    }

    @GetMapping(value = "delete")
    public void delete(@RequestBody DemoEntity demoEntity) {
        demoEntityDao.delete(demoEntity);
    }

    @GetMapping(value = "findOne")
    public DemoEntity findOne(Long id) {
        return demoEntityDao.findOneById(id);
    }
}
