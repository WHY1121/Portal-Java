package com.t2cloud.service;

import com.t2cloud.pojo.WfTemp;
import com.t2cloud.pojo.WfTempUser;
import com.t2cloud.pojo.WfTempStep;
import com.t2cloud.vo.WorkFlowForCreat;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:14
 */
public interface WorkflowDefinationService {

    /**
     *   定义模版
     */
    void insertWorkFlow(WorkFlowForCreat flowForCreat);


    List<WfTemp> list();

    void update(Long id,WorkFlowForCreat flowForCreat);

    void delete(Long[] tempIds);

    /**
     * 查询模版详情
     * @param tempId
     * @return
     */
    WfTemp show(Long tempId);

    /**
     * 修改流程状态
     */
    void updateStatus(Long id,boolean enabled);


}
