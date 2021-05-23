package com.hastemd.demo;

import com.hastemd.demo.aop.model.vo.Test;
import com.hastemd.demo.aop.service.impl.TestInsertServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class TestInsert extends DemoApplicationTests{

    @Autowired
    private TestInsertServiceImpl testInsertService;

    @org.junit.Test
    //@Transactional 这个注解会回滚测试类的事物
    public void testInsert(){
        testInsertService.insert(new Test());
    }
}
