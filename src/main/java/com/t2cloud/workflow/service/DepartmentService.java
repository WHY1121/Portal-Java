package com.t2cloud.workflow.service;

import com.t2cloud.workflow.pojo.PortalDepartment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/16
 * Time: 13:43
 */
public interface DepartmentService {

    /**
     * 部门集合
     * @return
     */
    List<PortalDepartment> list();

    /**
     * 增加部门
     */
    void insert(PortalDepartment portalDepartment);
    /**
     * 删除部门
     */
    void delete(Long departmentId);
    /**
     * 修改部门
     */
    void update(PortalDepartment portalDepartment);
    /**
     * 部门详情
     */

}
