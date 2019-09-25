package com.jnshu.mapper;

import com.jnshu.model.CheckNum;

import java.util.List;

public interface CheckNumMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CheckNum record);

    int insertSelective(CheckNum record);

    CheckNum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CheckNum record);

    int updateByPrimaryKey(CheckNum record);

    List<CheckNum> selectSelective(CheckNum record);

    int updateSelective(CheckNum record);
}