package com.t2cloud.service.impl;

import com.google.common.collect.Maps;
import com.t2cloud.mapper.PortalDepartmentMapper;
import com.t2cloud.mapper.PortalUserMapper;
import com.t2cloud.service.DepartmentService;
import com.t2cloud.vo.DepartmentMember;
import com.t2cloud.pojo.PortalDepartment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/16
 * Time: 13:43
 * 组织机构service
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private PortalDepartmentMapper portalDepartmentMapper;
    @Resource
    private PortalUserMapper portalUserMapper;

    @Override
    public List<PortalDepartment> list() {
        //no.1查询所有top节点
        List<PortalDepartment> topList = portalDepartmentMapper.findTopList();
        getAllDepartment(topList);
        return topList;
    }


    //递归查询所有部门
    public void getAllDepartment(List<PortalDepartment> topList) {
        //no.2查询所有top下的子节点
        if (null != topList && topList.size() > 0) {
            List<PortalDepartment> allChildren = null;
            Map<String, Object> maps = null;
            for (PortalDepartment department : topList) {
                department.setRoot(department.getIsTop() == 1 ? true : false);
                maps = Maps.newHashMap();
                maps.put("departmentId", department.getDepartmentId());
                department.setMemberCount(portalUserMapper.selectCount(maps));
                allChildren = portalDepartmentMapper.findAllChildren(department.getDepartmentId());
                if (null != allChildren && allChildren.size() > 0) {
                    department.setChildren(allChildren);
                }
                getAllDepartment(allChildren);
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

    /**
     * 获取单个部门下的成员
     *
     * @param departmentId
     * @return
     */
    @Override
    public List<DepartmentMember> allMembers(Long departmentId) {
        List<DepartmentMember> list = portalDepartmentMapper.selectMembersByDepartMentId(departmentId);
        return list;
    }
}
