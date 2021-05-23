package com.example.springStudy.transactional.dto;

import lombok.Data;

/**
 * t_one 表对应的实体类
 * @author lijie
 * @date 2021/5/23 20:06
 */
@Data
public class TOne {
    private Integer id;

    /**
    * 姓名
    */
    private String name;

    /**
    * 年龄
    */
    private Integer age;
}