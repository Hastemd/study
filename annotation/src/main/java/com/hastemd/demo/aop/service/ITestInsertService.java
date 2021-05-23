package com.hastemd.demo.aop.service;

import com.hastemd.demo.aop.model.vo.Test;

/**
 * 描述：运单表 服务实现层接口
 * @author lijie
 * @date Tue Feb 16 14:40:43 CST 2021
 */
public interface ITestInsertService {

	/**
	 * 描述：删除数据
	 *
	 * @param test 数据实体类
	 */
	int insert(Test test);
}