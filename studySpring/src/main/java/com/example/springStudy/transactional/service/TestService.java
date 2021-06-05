package com.example.springStudy.transactional.service;

import com.example.springStudy.transactional.dto.TOne;

/**
 * t_one 表 service
 *
 * @author lijie
 * @date 2021/5/23 18:56
 */
public interface TestService {

    /**
     * 根据 id 查询
     * @author lijie
     * @date 2021/5/23 20:07
     * @param id:
     * @return com.example.springStudy.transactional.dto.TOne
     */
    TOne selectByPrimaryKey(Integer id);

    /**
     * 插入一条数据
     * @author lijie
     * @date 2021/5/23 20:50
     * @param entity:
     * @return int
     */
    int insertOne(TOne entity);
}
