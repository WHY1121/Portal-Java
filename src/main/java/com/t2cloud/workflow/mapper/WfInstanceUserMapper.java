package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.WfInstanceUser;

public interface WfInstanceUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WfInstanceUser record);

    int insertSelective(WfInstanceUser record);

    WfInstanceUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WfInstanceUser record);

    int updateByPrimaryKey(WfInstanceUser record);
}