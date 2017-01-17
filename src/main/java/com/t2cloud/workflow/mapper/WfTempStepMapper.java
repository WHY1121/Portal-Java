package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.WfTempStep;

public interface WfTempStepMapper {
    int deleteByPrimaryKey(Long stepId);

    int insert(WfTempStep record);

    int insertSelective(WfTempStep record);

    WfTempStep selectByPrimaryKey(Long stepId);

    int updateByPrimaryKeySelective(WfTempStep record);

    int updateByPrimaryKey(WfTempStep record);
}