package com.t2cloud.controller;

import com.t2cloud.pojo.PortalDepartment;
import com.t2cloud.service.DepartmentService;
import com.t2cloud.vo.DepartmentMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/18
 * Time: 9:12
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    /**
     * 列表
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<PortalDepartment> list() {
        List<PortalDepartment> list = departmentService.list();
        return list;

    }

    /**
     * 获取部门下的成员
     */
    @RequestMapping(value = "/{id}/members", method = RequestMethod.GET)
    public  List<DepartmentMember> members(@PathVariable("id") Long id) {
        List<DepartmentMember> departmentMembers = departmentService.allMembers(id);
        return departmentMembers;
    }

    /**
     * 添加部门
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(PortalDepartment portalDepartment) {
        departmentService.insert(portalDepartment);

    }

    /**
     * 删除部门
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        departmentService.delete(id);

    }

    /**
     * 修改成员
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id, PortalDepartment portalDepartment) {
        departmentService.update(portalDepartment);

    }
}
