package com.t2cloud.mapper;

import com.t2cloud.pojo.WfInstance;

public interface WfInstanceMapper {
    int deleteByPrimaryKey(Long instanceId);

    int insert(WfInstance record);

    int insertSelective(WfInstance record);

    WfInstance selectByPrimaryKey(Long instanceId);

    int updateByPrimaryKeySelective(WfInstance record);

    int updateByPrimaryKey(WfInstance record);
}