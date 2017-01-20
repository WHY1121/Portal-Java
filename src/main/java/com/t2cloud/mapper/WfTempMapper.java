package com.t2cloud.mapper;

import com.t2cloud.pojo.WfTemp;

import java.util.List;

public interface WfTempMapper {
    int deleteByPrimaryKey(Long tempId);

    int insert(WfTemp record);

    int insertSelective(WfTemp record);

    WfTemp selectByPrimaryKey(Long tempId);

    int updateByPrimaryKeySelective(WfTemp record);

    int updateByPrimaryKey(WfTemp record);


    /**
     * 所有模版列表
     */
    List<WfTemp> list(WfTemp wfTemp);
}