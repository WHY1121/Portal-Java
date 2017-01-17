package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.WfTempUser;

public interface WfTempUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WfTempUser record);

    int insertSelective(WfTempUser record);

    WfTempUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WfTempUser record);

    int updateByPrimaryKey(WfTempUser record);
}