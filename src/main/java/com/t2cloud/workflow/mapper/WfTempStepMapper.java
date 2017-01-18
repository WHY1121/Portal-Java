package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.WfTempStep;

import java.util.Map;

public interface WfTempStepMapper {
    int deleteByPrimaryKey(Long stepId);

    int insert(WfTempStep record);

    int insertSelective(WfTempStep record);

    WfTempStep selectByPrimaryKey(Long stepId);

    int updateByPrimaryKeySelective(WfTempStep record);

    int updateByPrimaryKey(WfTempStep record);
    /**
     * 根据模版查询步骤
     * @param
     * @return
     */
    WfTempStep selectByTempId(Map<String,Object> map);
}