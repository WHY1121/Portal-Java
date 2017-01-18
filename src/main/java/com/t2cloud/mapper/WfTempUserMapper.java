package com.t2cloud.mapper;

import com.t2cloud.pojo.WfTempUser;

import java.util.List;

public interface WfTempUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WfTempUser record);

    int insertSelective(WfTempUser record);

    WfTempUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WfTempUser record);

    int updateByPrimaryKey(WfTempUser record);
    /**
     * 根据模版查询步骤
     * @param
     * @return
     */
    List<WfTempUser> selectByStepId(Long stepId);
}