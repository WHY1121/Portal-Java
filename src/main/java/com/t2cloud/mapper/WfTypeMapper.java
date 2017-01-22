package com.t2cloud.mapper;

import com.t2cloud.pojo.WfType;

public interface WfTypeMapper {
    int deleteByPrimaryKey(Long typeId);

    int insert(WfType record);

    int insertSelective(WfType record);

    WfType selectByPrimaryKey(Long typeId);

    int updateByPrimaryKeySelective(WfType record);

    int updateByPrimaryKey(WfType record);
}