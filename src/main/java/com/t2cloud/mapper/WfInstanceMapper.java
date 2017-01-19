package com.t2cloud.mapper;

import com.t2cloud.pojo.WfInstance;

import java.util.List;

public interface WfInstanceMapper {
    int deleteByPrimaryKey(Long instanceId);

    int insert(WfInstance record);

    int insertSelective(WfInstance record);

    WfInstance selectByPrimaryKey(Long instanceId);

    int updateByPrimaryKeySelective(WfInstance record);

    int updateByPrimaryKey(WfInstance record);

    /**
     * 运行实例列表
     * @return
     */
    List<WfInstance> list(WfInstance wfInstance);
}