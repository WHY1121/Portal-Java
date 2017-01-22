package com.t2cloud.controller;

import com.t2cloud.pojo.WfInstance;
import com.t2cloud.pojo.WfInstanceStep;
import com.t2cloud.pojo.WfInstanceUser;
import com.t2cloud.service.WorkflowInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:17
 */
@RestController
public class WorkflowInstanceController {

    @Autowired
    private WorkflowInstanceService workflowInstanceService;

    /**
     * 启动流程
     */
    @RequestMapping(value = "/startWorkFlow", method = RequestMethod.POST)
    public void startWorkFlow(WfInstance wfInstance) {
        workflowInstanceService.workflowProcess(wfInstance);
    }

    /**
     * 待审批
     */
    @RequestMapping(value = "/waitWorkFlowProcess", method = RequestMethod.POST)
    public void waitWorkFlowProcess(String handleId) {
        workflowInstanceService.waitWorkFlowProcess(handleId);
    }

    /**
     * 我的审批
     *
     * @return
     */
    @RequestMapping(value = "/myWorkFlowProcess", method = RequestMethod.PUT)
    public String myWorkFlowProcess(String userId) {
        workflowInstanceService.myWorkFlowProcess(userId);

        return "hello world";
    }

    /**
     * 审批
     *
     * @return
     */
    @RequestMapping(value = "/approveWorkFlowProcess", method = RequestMethod.POST)
    public void approveWorkFlowProcess(Long instanceId, WfInstanceStep wfInstanceStep, WfInstanceUser wfInstanceUser) {
        workflowInstanceService.approveWorkFlowProcess(instanceId, wfInstanceStep, wfInstanceUser);
    }

    /**
     * 修改待审批的流程实例
     *
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void update(WfInstance wfInstance) {
        workflowInstanceService.updateWorkFlowProcess(wfInstance);
    }

    /**
     * 审批转接给他人
     */
    @RequestMapping(value = "/changeApproveUser", method = RequestMethod.GET)
    public void changeApproveUser(Long id, String handleId, String handleName) {
        workflowInstanceService.changeApproveUser(id, handleId, handleName);
    }
}
