package com.t2cloud.service;

import com.t2cloud.pojo.WfInstance;
import com.t2cloud.pojo.WfInstanceStep;
import com.t2cloud.pojo.WfInstanceUser;
import com.t2cloud.vo.WfTaskBo;

import java.util.List;

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
   void updateWorkFlowProcess(WfInstance instance);
    /**
     * 审批流程实例
     */
    void approveWorkFlowProcess(Long instanceId,WfInstanceStep wfInstanceStep,WfInstanceUser wfInstanceUser);
    /**
     * 待审批
     */
    List<WfTaskBo> waitWorkFlowProcess(Long handleId);
    /**
     * 已审批
     */
    void myWorkFlowProcess(String userId);

}
