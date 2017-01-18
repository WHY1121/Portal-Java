package com.t2cloud.service;

import com.t2cloud.pojo.WfInstance;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:16
 */
public interface WorkflowInstanceService {

    /**
     * 启动流程实例
     */
    void workflowProcess(WfInstance wfInstance);
    /**
     * 修改流程实例
     */
   void updateWorkFlowProcess();
    /**
     * 审批流程实例
     */
    void approveWorkFlowProcess();
    /**
     * 待审批
     */
    void waitWorkFlowProcess();
    /**
     * 已审批
     */
    void finishWorkFlowProcess();

}
