package com.hastemd.demo.aop.service.impl;

import com.hastemd.demo.aop.dao.ITestInsertDao;
import com.hastemd.demo.aop.model.vo.Test;
import com.hastemd.demo.aop.service.ITestInsertService;
import com.hastemd.demo.aop.status.anno.BusinessStatusAnno;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：运单表服务实现层
 * @author lijie
 * @date Tue Feb 16 14:40:43 CST 2021
 */
@Service
@Slf4j
public class TestInsertServiceImpl implements ITestInsertService {

	@Autowired
	private ITestInsertDao testInsertDao;

	@BusinessStatusAnno()
	@Override
	public int insert(Test test){
		testInsertDao.insert(test);
		//int i = 1/0;
		testInsertDao.insert(test);
		return 1;
	}
}
