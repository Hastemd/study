package com.example.springStudy.transactional.service.impl;

import com.example.springStudy.transactional.dto.TOne;
import com.example.springStudy.transactional.dao.TOneDao;
import com.example.springStudy.transactional.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * t_one 表 service
 *
 * @author lijie
 * @date 2021/5/23 18:56
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TOneDao tOneDao;

    /**
     * 根据 id 查询
     * @author lijie
     * @date 2021/5/23 19:01
     * @param id:
     * @return com.example.springStudy.transactional.dto.TOne
     */
    @Override
    public TOne selectByPrimaryKey(Integer id){
        TOne tOne = tOneDao.selectByPrimaryKey(id);
        return tOne;
    }

}
