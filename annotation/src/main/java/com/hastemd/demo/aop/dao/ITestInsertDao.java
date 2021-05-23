package com.hastemd.demo.aop.dao;

import com.hastemd.demo.aop.model.vo.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：运单表 Dao接口
 * @author lijie
 * @date Tue Feb 16 14:40:43 CST 2021
 */
@Repository
public interface ITestInsertDao {

	/**
	 * 描述：删除数据
	 */
	int insert(Test test);

}