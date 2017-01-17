package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.WfTemp;

public interface WfTempMapper {
    int deleteByPrimaryKey(Long tempId);

    int insert(WfTemp record);

    int insertSelective(WfTemp record);

    WfTemp selectByPrimaryKey(Long tempId);

    int updateByPrimaryKeySelective(WfTemp record);

    int updateByPrimaryKey(WfTemp record);
}