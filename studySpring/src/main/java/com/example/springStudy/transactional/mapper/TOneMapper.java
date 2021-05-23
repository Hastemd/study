package com.example.springStudy.transactional.mapper;

import com.example.springStudy.transactional.dto.TOne;
import org.springframework.stereotype.Repository;

@Repository
public interface TOneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TOne record);

    int insertSelective(TOne record);

    TOne selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TOne record);

    int updateByPrimaryKey(TOne record);
}