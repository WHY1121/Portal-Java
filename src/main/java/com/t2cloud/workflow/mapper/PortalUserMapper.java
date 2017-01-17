package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.PortalUser;

public interface PortalUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(PortalUser record);

    int insertSelective(PortalUser record);

    PortalUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(PortalUser record);

    int updateByPrimaryKey(PortalUser record);
}