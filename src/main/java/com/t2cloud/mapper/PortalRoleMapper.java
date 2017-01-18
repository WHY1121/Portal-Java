package com.t2cloud.mapper;

import com.t2cloud.pojo.PortalRole;

public interface PortalRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(PortalRole record);

    int insertSelective(PortalRole record);

    PortalRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(PortalRole record);

    int updateByPrimaryKey(PortalRole record);
}