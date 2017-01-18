package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.PortalUser;

import java.util.Map;

public interface PortalUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(PortalUser record);

    int insertSelective(PortalUser record);

    PortalUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(PortalUser record);

    int updateByPrimaryKey(PortalUser record);


    /**
     * 查询人数
     * @param map
     * @return
     */
    Integer selectCount(Map<String,Object> map);
}