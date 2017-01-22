package com.t2cloud.mapper;

import com.t2cloud.pojo.WfInstanceUser;
import com.t2cloud.vo.WfTaskBo;

import java.util.List;

public interface WfInstanceUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WfInstanceUser record);

    int insertSelective(WfInstanceUser record);

    WfInstanceUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WfInstanceUser record);

    int updateByPrimaryKey(WfInstanceUser record);
    /**
     * 查询代办任务
     */
    List<WfTaskBo> selectWorkFlowByHandleId(String handleId);

    /**
     * 按照查询条件查找
     * @param wfInstanceUser
     * @return
     */
    List<WfInstanceUser> selectBySelective(WfInstanceUser wfInstanceUser);
}