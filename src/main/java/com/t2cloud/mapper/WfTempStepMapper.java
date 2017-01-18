package com.t2cloud.mapper;

import com.t2cloud.pojo.WfTempStep;

import java.util.List;

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
    List<WfTempStep> selectByTempId(Long tempId);
}