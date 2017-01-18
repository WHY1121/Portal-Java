package com.t2cloud.workflow.service.impl;

import com.google.common.collect.Maps;
import com.t2cloud.workflow.mapper.WfInstanceMapper;
import com.t2cloud.workflow.mapper.WfInstanceStepMapper;
import com.t2cloud.workflow.mapper.WfInstanceUserMapper;
import com.t2cloud.workflow.mapper.WfTempStepMapper;
import com.t2cloud.workflow.pojo.WfInstance;
import com.t2cloud.workflow.pojo.WfInstanceStep;
import com.t2cloud.workflow.pojo.WfTempStep;
import com.t2cloud.workflow.service.WorkflowInstanceService;
import com.t2cloud.workflow.util.WorkFlowConstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

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

        //no.4自动开启流程(第一步)
        Map<String, Object> map = Maps.newHashMap();
        map.put("tempId", wfInstanc.getTempId());
        map.put("orderNo", WorkFlowConstance.STEP + 1);
        WfTempStep wfTempStep = wfTempStepMapper.selectByTempId(map);
        WfInstanceStep wfInstanceStep = new WfInstanceStep();
        //设置步骤信息
        wfInstanceStep.setInstanceId(wfInstanc.getInstanceId());
        wfInstanceStep.setStepName(wfTempStep.getName());
        wfInstanceStep.setType(wfTempStep.getType());
        wfInstanceStep.setOrderNo(wfTempStep.getOrderNo());
        wfInstanceStep.setStepType(wfTempStep.getStepType());














        wfInstanceStep.setBeginTime(new Date());
        //TODO 上下节点

        //设置流程审批人
        wfInstanceStepMapper.insert(wfInstanceStep);

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
