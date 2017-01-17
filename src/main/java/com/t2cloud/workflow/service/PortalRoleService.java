package com.t2cloud.workflow.service;


import com.t2cloud.workflow.pojo.PortalRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/16
 * Time: 16:42
 */
public interface PortalRoleService {
    /**
     * 列表
     * @return
     */
    List<PortalRole> list();


    /**
     * 删除
     */
    void delete();

    /**
     * 修改
     */
    void update();

    /**
     * 增加
     */
    void add();

}
