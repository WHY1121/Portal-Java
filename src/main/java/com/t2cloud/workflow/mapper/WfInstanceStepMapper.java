package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.WfInstanceStep;

public interface WfInstanceStepMapper {
    int deleteByPrimaryKey(Long stepId);

    int insert(WfInstanceStep record);

    int insertSelective(WfInstanceStep record);

    WfInstanceStep selectByPrimaryKey(Long stepId);

    int updateByPrimaryKeySelective(WfInstanceStep record);

    int updateByPrimaryKey(WfInstanceStep record);
}