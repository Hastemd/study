package com.example.springStudy.transactional.controller;

import com.example.springStudy.transactional.dto.TOne;
import com.example.springStudy.transactional.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
}
