package com.hastemd.demo.aop.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：运单表实体类
 * @author lijie
 * @date Tue Feb 16 14:40:43 CST 2021
 */
@Data
public class Test implements Serializable {

	private Integer id;

	private String name;

	private Integer age;

}