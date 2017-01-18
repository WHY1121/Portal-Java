package com.t2cloud.workflow.controller;

import com.t2cloud.workflow.pojo.PortalDepartment;
import com.t2cloud.workflow.service.PortalRoleService;
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
 * Time: 11:49
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private PortalRoleService portalRoleService;

    /**
     * 列表
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<PortalDepartment> list() {

        return null;

    }

    /**
     * 获取部门下的成员
     */
    @RequestMapping(value = "/:id/members", method = RequestMethod.GET)
    public void members(@PathVariable("id") String id) {


    }

    /**
     * 添加部门
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void add(PortalDepartment portalDepartment) {


    }

    /**
     * 删除部门
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

    }

    /**
     * 修改成员
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id, PortalDepartment portalDepartment) {

    }
}
