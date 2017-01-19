package com.t2cloud.service.impl;

import com.t2cloud.mapper.WfInstanceMapper;
import com.t2cloud.mapper.WfInstanceStepMapper;
import com.t2cloud.mapper.WfInstanceUserMapper;
import com.t2cloud.mapper.WfTempStepMapper;
import com.t2cloud.pojo.*;
import com.t2cloud.util.WorkFlowConstance;
import com.t2cloud.service.WorkflowDefinationService;
import com.t2cloud.service.WorkflowInstanceService;
import com.t2cloud.vo.WfTaskBo;
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
    @Resource
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
//        //查询启动的模版 填写第一步信息，开启下一步信息
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
                    //通过
                    wfInstanceStep.setStatus(WorkFlowConstance.PASS);
                    wfInstanceStepMapper.insert(wfInstanceStep);
                    //设置用户
                    List<WfTempUser> tempUsers = wfTempStep.getTempUsers();
                    if (null != wfTempStep.getTempUsers() && tempUsers.size() > 0) {
                        for (WfTempUser wfTempUser : tempUsers) {
                            //循环插入用户信息
                            WfInstanceUser wfInstanceUser = new WfInstanceUser();
                            wfInstanceUser.setHandlerName(wfTempUser.getHandlerName());
                            wfInstanceUser.setHandlerId(wfTempUser.getHandlerId());
                            //TODO 审核意见
                            wfInstanceUserMapper.insert(wfInstanceUser);
                        }
                    }
                }
                //自动开启下一步信息
                if (wfTempStep.getOrderNo() == 2) {
                    WfInstanceStep wfInstanceStep = new WfInstanceStep();
                    //设置步骤信息
                    wfInstanceStep.setInstanceId(wfInstanc.getInstanceId());
                    wfInstanceStep.setStepName(wfTempStep.getName());
                    wfInstanceStep.setOrderNo(wfTempStep.getOrderNo());
                    wfInstanceStep.setBeginTime(new Date());
                    wfInstanceStepMapper.insert(wfInstanceStep);
                    //填写审核人
                    List<WfTempUser> tempUsers = wfTempStep.getTempUsers();
                    if (null != wfTempStep.getTempUsers() && tempUsers.size() > 0) {
                        for (WfTempUser wfTempUser : tempUsers) {
                            //循环插入用户信息
                            WfInstanceUser wfInstanceUser = new WfInstanceUser();
                            wfInstanceUser.setHandlerName(wfTempUser.getHandlerName());
                            wfInstanceUser.setHandlerId(wfTempUser.getHandlerId());
                            wfInstanceUserMapper.insert(wfInstanceUser);
                        }
                    }

                }
            }
        }

    }

    /**
     * 审批
     */
    @Override
    public void approveWorkFlowProcess(Long instanceId) {
        //no.1 修改流程状态为 3：审批中  直到审批到最后节点  修改状态为 4：审批未通过  5：审批通过
        WfInstance wfInstance = wfInstanceMapper.selectByPrimaryKey(instanceId);
        //修改为审批中
        wfInstance.setStatus(WorkFlowConstance.IN_APPROVE);
        wfInstanceMapper.updateByPrimaryKey(wfInstance);

        //修改当前流程步骤信息

        //修改当前流程步骤审批人信息


        //no.2审批完当前节点，自动流转到下一个节点


    }

    /**
     * 待审批 根据用户id 查询待审批
     */
    @Override
    public List<WfTaskBo> waitWorkFlowProcess(Long handleId) {
        //审核步骤表里的status为空
        List<WfTaskBo> wfTaskBos = wfInstanceUserMapper.selectWorkFlowByHandleId(handleId);
        return wfTaskBos;

    }


    /**
     * 已审批
     */
    @Override
    public void finishWorkFlowProcess() {
        //审核步骤表里出现最后节点  根据用户id查询
        //status 为审核通过
        List<WfInstance> wfInstances = wfInstanceMapper.list(null);
        //查询所有步骤 status为通过
        if (null != wfInstances && wfInstances.size() > 0) {

            for (WfInstance wfInstance : wfInstances) {
                WfInstanceStep stepCondition = new WfInstanceStep();
                stepCondition.setInstanceId(wfInstance.getInstanceId());
                List<WfInstanceStep> wfInstanceSteps = wfInstanceStepMapper.selectBySelective(stepCondition);
                if (null != wfInstanceSteps && wfInstanceSteps.size() > 0) {
                    for (WfInstanceStep wfInstanceStep : wfInstanceSteps) {
                        WfInstanceUser userContdition = new WfInstanceUser();
                        List<WfInstanceUser> wfInstanceUsers = wfInstanceUserMapper.selectBySelective(userContdition);
                    }
                }

            }
        }
        //查询所有的

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
