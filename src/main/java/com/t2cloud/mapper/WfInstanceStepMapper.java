package com.t2cloud.mapper;

import com.t2cloud.pojo.WfInstanceStep;

public interface WfInstanceStepMapper {
    int deleteByPrimaryKey(Long stepId);

    int insert(WfInstanceStep record);

    int insertSelective(WfInstanceStep record);

    WfInstanceStep selectByPrimaryKey(Long stepId);

    int updateByPrimaryKeySelective(WfInstanceStep record);

    int updateByPrimaryKey(WfInstanceStep record);
}