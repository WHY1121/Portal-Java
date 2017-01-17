package com.t2cloud.workflow.mapper;

import com.t2cloud.workflow.pojo.PortalDepartment;

import java.util.List;

public interface PortalDepartmentMapper {
    int deleteByPrimaryKey(Long departmentId);

    int insert(PortalDepartment record);

    int insertSelective(PortalDepartment record);

    PortalDepartment selectByPrimaryKey(Long departmentId);

    int updateByPrimaryKeySelective(PortalDepartment record);

    int updateByPrimaryKey(PortalDepartment record);

    /**
     * 查询所有子节点
     * @param departmentId
     * @return
     */
    List<PortalDepartment> findAllChildren(Long departmentId);

    /**
     * 查询所有顶级节点
     * @return
     */
    List<PortalDepartment> findTopList();
}