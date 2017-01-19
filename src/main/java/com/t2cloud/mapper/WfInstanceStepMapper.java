package com.t2cloud.mapper;

import com.t2cloud.pojo.WfInstanceStep;

import java.util.List;

public interface WfInstanceStepMapper {
    int deleteByPrimaryKey(Long stepId);

    int insert(WfInstanceStep record);

    int insertSelective(WfInstanceStep record);

    WfInstanceStep selectByPrimaryKey(Long stepId);

    int updateByPrimaryKeySelective(WfInstanceStep record);

    int updateByPrimaryKey(WfInstanceStep record);

    /**
     * 按条件查询
     * @param wfInstanceStep
     * @return
     */
    List<WfInstanceStep> selectBySelective(WfInstanceStep wfInstanceStep);
}