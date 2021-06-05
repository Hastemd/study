package com.example.springStudy.transactional.controller;

import com.example.springStudy.transactional.dto.TOne;
import com.example.springStudy.transactional.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试类 controller
 *
 * @author lijie
 * @date 2021/5/23 18:55
 */
@RestController
@RequestMapping(value = "/test")
@Api(value="test", tags = "test")
@Slf4j
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/getOneStr")
    @ApiOperation("查询")
    public String testReturnStr(){
        return "hello";
    }

    @PostMapping("/select")
    @ApiOperation("查询")
    public TOne testSelect(){
        return testService.selectByPrimaryKey(1);
    }

    @PostMapping("/insert")
    @ApiOperation("插入")
    public String testInsert(){
        TOne entity = new TOne();
        entity.setName("name");
        entity.setAge(18);
        try {
            testService.insertOne(entity);
        } catch (Exception e) {
            log.error("insert 失败",e);
            return e.getMessage();
        }
        return "插入成功";
    }

    @PostMapping("/insert2")
    @ApiOperation("插入")
    public String testInsert2(){
        try {
            this.testPrivateInsert();
        } catch (Exception e) {
            log.error("insert 失败",e);
            return e.getMessage();
        }
        return "插入成功";
    }

    private int testPrivateInsert(){
        TOne entity = new TOne();
        entity.setName("name");
        entity.setAge(18);
        return testService.insertOne(entity);
    }
}
