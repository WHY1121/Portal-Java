package com.t2cloud.workflow.service.impl;

import com.t2cloud.workflow.mapper.PortalDepartmentMapper;
import com.t2cloud.workflow.pojo.PortalDepartment;
import com.t2cloud.workflow.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/16
 * Time: 13:43
 * 组织机构service
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

@Resource
private PortalDepartmentMapper portalDepartmentMapper;
    @Override
    public List<PortalDepartment> list() {
        //TODO 查询出所有部门总数
        //no.1查询所有top节点
        List<PortalDepartment> topList = portalDepartmentMapper.findTopList();
        List<PortalDepartment> list=new ArrayList<>();
        getAllDepartment(topList,list);
        return list;
    }


    //递归查询所有部门
    public void getAllDepartment(List<PortalDepartment> topList,List<PortalDepartment> list){
        //no.2查询所有top下的子节点
        if(null!=topList && topList.size()>0){
            for(PortalDepartment department:topList){
                department.setName(department.getName());
                list.add(department);
                List<PortalDepartment> allChildren = portalDepartmentMapper.findAllChildren(department.getDepartmentId());
                getAllDepartment(allChildren,list);
            }
        }
    }
    @Override
    public void insert(PortalDepartment portalDepartment) {
        portalDepartmentMapper.insert(portalDepartment);
    }

    @Override
    public void delete(Long departmentId) {
        portalDepartmentMapper.deleteByPrimaryKey(departmentId);
    }

    @Override
    public void update(PortalDepartment portalDepartment) {
        portalDepartmentMapper.updateByPrimaryKeySelective(portalDepartment);
    }
}
