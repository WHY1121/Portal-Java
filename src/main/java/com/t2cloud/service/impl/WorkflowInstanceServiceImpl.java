package com.t2cloud.service.impl;

import com.t2cloud.mapper.WfInstanceMapper;
import com.t2cloud.mapper.WfInstanceStepMapper;
import com.t2cloud.mapper.WfInstanceUserMapper;
import com.t2cloud.mapper.WfTempStepMapper;
import com.t2cloud.pojo.*;
import com.t2cloud.util.WorkFlowConstance;
import com.t2cloud.service.WorkflowDefinationService;
import com.t2cloud.service.WorkflowInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:16
 * 流程实例业务实现
 */
@Service
public class WorkflowInstanceServiceImpl implements WorkflowInstanceService {


    @Resource
    private WfInstanceMapper wfInstanceMapper;
    @Resource
    private WfTempStepMapper wfTempStepMapper;
    @Resource
    private WfInstanceStepMapper wfInstanceStepMapper;
    @Resource
    private WfInstanceUserMapper wfInstanceUserMapper;
    @Autowired
    private WorkflowDefinationService workflowDefinationService;


    /**
     * 启动流程实例
     */
    @Override
    public void workflowProcess(WfInstance wfInstanc) {
        //no.1填写审批信息

        //no.2审批流程信息
        wfInstanc.setCreateTimestamp(new Date());
        //初始状态待审批
        wfInstanc.setStatus(WorkFlowConstance.NOT_APPROVE);

        //no.3插入流程审批信息
        wfInstanceMapper.insert(wfInstanc);

        //no.4自动开启流程
        //查询启动的模版 填写第一步信息，开启下一步信息
        WfTemp show = workflowDefinationService.show(wfInstanc.getTempId());
        List<WfTempStep> wfTempStepList = show.getWfTempStepList();
        if (null != wfTempStepList && wfTempStepList.size() > 0) {
            for (WfTempStep wfTempStep : wfTempStepList) {
                //填写第一步信息
                if (wfTempStep.getOrderNo() == 1) {
                    WfInstanceStep wfInstanceStep = new WfInstanceStep();
                    //设置步骤信息
                    wfInstanceStep.setInstanceId(wfInstanc.getInstanceId());
                    wfInstanceStep.setStepName(wfTempStep.getName());
                    wfInstanceStep.setOrderNo(wfTempStep.getOrderNo());
                    wfInstanceStep.setBeginTime(new Date());
                    wfInstanceStep.setEndTime(new Date());
                    wfInstanceStepMapper.insert(wfInstanceStep);
                    //设置用户

                    List<WfTempUser> tempUsers = wfTempStep.getTempUsers();
                    if (null != wfTempStep.getTempUsers() && tempUsers.size() > 0) {
                        for(WfTempUser wfTempUser:tempUsers){
                            //循环插入用户信息
                        }
                    }
                }
                //自动开启下一步信息
            }
        }

    }

    /**
     * 审批
     */
    @Override
    public void approveWorkFlowProcess() {

    }

    /**
     * 待审批
     */
    @Override
    public void waitWorkFlowProcess() {

        //

    }


    /**
     * 已审批
     */
    @Override
    public void finishWorkFlowProcess() {

    }

    /**
     * 修改审批
     */
    @Override
    public void updateWorkFlowProcess() {

        //判断流程状态    为待审批


        //

    }


}
