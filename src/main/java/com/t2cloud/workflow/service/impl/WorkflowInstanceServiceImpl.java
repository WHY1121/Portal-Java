package com.t2cloud.workflow.service.impl;

import com.t2cloud.workflow.mapper.WfInstanceMapper;
import com.t2cloud.workflow.mapper.WfTempMapper;
import com.t2cloud.workflow.pojo.WfInstance;
import com.t2cloud.workflow.pojo.WfTemp;
import com.t2cloud.workflow.service.WorkflowInstanceService;
import com.t2cloud.workflow.util.WorkFlowConstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:16
 * 流程实例业务实现
 */
@Service
public class WorkflowInstanceServiceImpl implements WorkflowInstanceService{



    @Resource
    private WfInstanceMapper wfInstanceMapper;
    @Resource
    private WfTempMapper wfTempMapper;


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
//        WfTemp wfTemp=wfTempMapper.selectByPrimaryKey();









    }

    /**
     * 查询待审批
     */
    @Override
    public void updateWorkFlowProcess() {

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









}
