package com.example.springStudy.transactional.dao;

import com.example.springStudy.transactional.dto.TOne;
import org.springframework.stereotype.Repository;

@Repository
public interface TOneDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TOne record);

    int insertSelective(TOne record);

    TOne selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TOne record);

    int updateByPrimaryKey(TOne record);
}