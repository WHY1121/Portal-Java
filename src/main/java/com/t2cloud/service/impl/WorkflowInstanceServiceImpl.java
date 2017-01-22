package com.t2cloud.service.impl;

import com.t2cloud.mapper.WfInstanceMapper;
import com.t2cloud.mapper.WfInstanceStepMapper;
import com.t2cloud.mapper.WfInstanceUserMapper;
import com.t2cloud.mapper.WfTempStepMapper;
import com.t2cloud.pojo.*;
import com.t2cloud.service.WorkflowDefinationService;
import com.t2cloud.service.WorkflowInstanceService;
import com.t2cloud.util.WorkFlowConstance;
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
@Service(value = "workflowInstanceService")
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
        //查询启动的模版 开启步骤信息
        autoApprove(wfInstanc);

    }

    /**
     * 自动开启流程步骤
     *
     * @param wfInstanc
     */
    private void autoApprove(WfInstance wfInstanc) {
        WfTemp show = workflowDefinationService.show(wfInstanc.getTempId());
        List<WfTempStep> wfTempStepList = show.getWfTempStepList();
//        if (null != wfTempStepList && wfTempStepList.size() > 0) {
//            for (WfTempStep wfTempStep : wfTempStepList) {
//                //填写第一步信息
//                if (wfTempStep.getOrderNo() == WorkFlowConstance.STEP) {
//                    approveStep(wfInstanc, wfTempStep, WorkFlowConstance.CURRENTSTEP, null, wfTempStep.getLast());
//                    if (wfTempStep.getLast()) {
//                        return;
//                    }
//                }
//                //自动开启下一步信息
//                if (wfTempStep.getOrderNo() == WorkFlowConstance.STEP + 1) {
//                    approveStep(wfInstanc, wfTempStep, WorkFlowConstance.NEXTSTEP, null, wfTempStep.getLast());
//                    return;
//                }
//            }
//        }
        if (null != wfTempStepList && wfTempStepList.size() > 0) {
            approveStep(wfInstanc, wfTempStepList.get(0));
        }
    }

    /**
     * 自动流转步骤信息
     *
     * @param wfInstanc
     * @param wfTempStep
     */
    private void approveStep(WfInstance wfInstanc, WfTempStep wfTempStep) {
        WfInstanceStep wfInstanceStep = new WfInstanceStep();
        //设置步骤信息
        wfInstanceStep.setInstanceId(wfInstanc.getInstanceId());
        wfInstanceStep.setStepName(wfTempStep.getName());
        wfInstanceStep.setOrderNo(wfTempStep.getOrderNo());
        wfInstanceStep.setBeginTime(new Date());
        wfInstanceStep.setLast(wfTempStep.getLast());
        //TODO 状态信息待定
        wfInstanceStepMapper.insert(wfInstanceStep);
        //设置用户
        List<WfTempUser> tempUsers = wfTempStep.getTempUsers();
        if (null != wfTempStep.getTempUsers() && tempUsers.size() > 0) {
            WfInstanceUser instanceUser = null;
            for (WfTempUser wfTempUser : tempUsers) {
                //循环插入用户信息
                instanceUser = new WfInstanceUser();
                instanceUser.setHandlerName(wfTempUser.getHandlerName());
                instanceUser.setHandlerId(wfTempUser.getHandlerId());
                instanceUser.setStepId(wfInstanceStep.getStepId());
                wfInstanceUserMapper.insert(instanceUser);
            }
        }
    }


//    /**
//     * @param wfInstanc
//     * @param wfTempStep
//     * @param flag       作为当前步骤和下一步的标识
//     */
//    private void approveStep(WfInstance wfInstanc, WfTempStep wfTempStep, String flag, WfInstanceUser wfInstanceUser, Boolean isLast) {
//        //TODO 多人审批逻辑
//        WfInstanceStep wfInstanceStep = new WfInstanceStep();
//        //设置步骤信息
//        wfInstanceStep.setInstanceId(wfInstanc.getInstanceId());
//        wfInstanceStep.setStepName(wfTempStep.getName());
//        wfInstanceStep.setOrderNo(wfTempStep.getOrderNo());
//        wfInstanceStep.setBeginTime(new Date());
//        if (!flag.equalsIgnoreCase(WorkFlowConstance.NEXTSTEP)) {
//            wfInstanceStep.setEndTime(new Date());
//            //修改步骤状态   根据审批人的结果来审核步骤状态
//            if (wfInstanceUser != null) {
//                wfInstanceStep.setStatus(wfInstanceUser.getResult());
//            }
//
//        }
//        wfInstanceStepMapper.insert(wfInstanceStep);
//        //设置用户
//        List<WfTempUser> tempUsers = wfTempStep.getTempUsers();
//        if (null != wfTempStep.getTempUsers() && tempUsers.size() > 0) {
//            WfInstanceUser instanceUser = null;
//            for (WfTempUser wfTempUser : tempUsers) {
//                //循环插入用户信息
//                instanceUser = new WfInstanceUser();
//                //审批人意见
//                if (!flag.equalsIgnoreCase(WorkFlowConstance.NEXTSTEP)) {
//                    instanceUser.setHandlerName(wfInstanceUser.getHandlerName());
//                    instanceUser.setHandlerId(wfInstanceUser.getHandlerId());
//                    instanceUser.setResult(wfInstanceUser.getResult());
//                    instanceUser.setSuggestion(wfInstanceUser.getSuggestion());
//                    instanceUser.setStepId(wfInstanceStep.getStepId());
//                } else {
//                    instanceUser.setHandlerName(wfTempUser.getHandlerName());
//                    instanceUser.setHandlerId(wfTempUser.getHandlerId());
//                    instanceUser.setStepId(wfInstanceStep.getStepId());
//                }
//                wfInstanceUserMapper.insert(instanceUser);
//            }
//        }
//
//        //是不是最终节点
//        if (isLast && !flag.equalsIgnoreCase(WorkFlowConstance.NEXTSTEP)) {
//            WfInstance instance = new WfInstance();
//            WfInstanceStep instanceStep = new WfInstanceStep();
//            wfInstanceStep.setStepId(wfInstanceStep.getStepId());
//            if (wfInstanceUser.getResult() == 0) {
//                //通过
//                instanceStep.setStatus(5);
//            } else if (wfInstanceUser.getResult() == 1) {
//                //不通过
//                instanceStep.setStatus(4);
//            }
//            //根据审批人结果处理流程状态
//            instance.setStatus(instanceStep.getStatus());
//            instance.setInstanceId(wfInstanc.getInstanceId());
//
//            wfInstanceStepMapper.updateByPrimaryKeySelective(wfInstanceStep);
//
//            wfInstanceMapper.updateByPrimaryKeySelective(instance);
//        }
//    }

    /**
     * 审批
     */
    @Override
    public void approveWorkFlowProcess(Long instanceId, WfInstanceStep wfInstanceStep, WfInstanceUser wfInstanceUser) {
        //no.1 修改流程状态为 3：审批中  直到审批到最后节点  修改状态为 4：审批未通过  5：审批通过
        WfInstance wfInstance = wfInstanceMapper.selectByPrimaryKey(instanceId);
        if(wfInstance.getStatus()==WorkFlowConstance.PASS_APPROVE){
            //TODO 返回审批已完成
        }else if(wfInstance.getStatus()==WorkFlowConstance.NOT_PASS_APPROVE){

        }
        //修改为审批中
        wfInstance.setStatus(WorkFlowConstance.IN_APPROVE);
        wfInstanceMapper.updateByPrimaryKeySelective(wfInstance);
        //修改当前流程步骤审批人信息
        wfInstanceUser.setHandleTime(new Date());
        wfInstanceUserMapper.updateByPrimaryKeySelective(wfInstanceUser);
        //按照审批人的状态修改当前流程步骤状态
        wfInstanceStep.setStatus(wfInstanceUser.getResult());
        wfInstanceStep.setEndTime(new Date());
        wfInstanceStepMapper.updateByPrimaryKeySelective(wfInstanceStep);
        //是不是最终节点
        if (wfInstanceStep.getLast() || wfInstanceUser.getResult() == WorkFlowConstance.NOT_PASS) {
            WfInstance instance = new WfInstance();
            //设置流程实例状态
            if (wfInstanceUser.getResult() == WorkFlowConstance.PASS) {
                //通过
                instance.setStatus(WorkFlowConstance.PASS_APPROVE);
            } else if (wfInstanceUser.getResult() == WorkFlowConstance.NOT_PASS) {
                //不通过
                instance.setStatus(WorkFlowConstance.NOT_PASS_APPROVE);
            }
            //设置流程实例步骤状态
            instance.setInstanceId(instanceId);
            wfInstanceMapper.updateByPrimaryKeySelective(instance);
        }
        //no.2审批完当前节点，自动流转到下一个节点
        //TODO 审核不通过，不能流转下一个节点，且此流程  审核不通过
//        if () {
//            WfInstance instance = wfInstanceMapper.selectByPrimaryKey(wfInstance.getInstanceId());
//            instance.setStatus(WorkFlowConstance.NOT_PASS_APPROVE);
//            wfInstanceMapper.updateByPrimaryKeySelective(instance);
//        }
        else {
            //查询当前正在审核的流程
            WfTemp show = workflowDefinationService.show(wfInstance.getTempId());
            List<WfTempStep> wfTempStepList = show.getWfTempStepList();
//            for (WfTempStep step : wfTempStepList) {
//                if (step.getOrderNo() == wfInstanceStep.getOrderNo() + 1) {
//                    approveStep(wfInstance, step, WorkFlowConstance.NEXTSTEP, null, step.getLast());
//                    return;
//                }
//            }
            if (null != wfTempStepList && wfTempStepList.size() > 0) {
                approveStep(wfInstance,wfTempStepList.get(wfInstanceStep.getOrderNo()));
            }

        }
    }

    /**
     * 待审批 根据用户id 查询待审批(？？查询当前步骤的前后各一级步骤)
     */
    @Override
    public List<WfTaskBo> waitWorkFlowProcess(String handleId) {
        //审核步骤表里的status为空
        List<WfTaskBo> wfTaskBos = wfInstanceUserMapper.selectWorkFlowByHandleId(handleId);
        return wfTaskBos;
    }


    /**
     * 查询我的流程审批
     */
    @Override
    public void myWorkFlowProcess(String userId) {
        //审核步骤表里出现最后节点  根据发起人id查询
        WfInstance instance = new WfInstance();
        instance.setCreateId(userId);
        List<WfInstance> wfInstances = wfInstanceMapper.list(instance);
        //查询所有步骤
        if (null != wfInstances && wfInstances.size() > 0) {
            for (WfInstance wfInstance : wfInstances) {
                WfInstanceStep stepCondition = new WfInstanceStep();
                stepCondition.setInstanceId(wfInstance.getInstanceId());
                List<WfInstanceStep> wfInstanceSteps = wfInstanceStepMapper.selectBySelective(stepCondition);
                if (null != wfInstanceSteps && wfInstanceSteps.size() > 0) {
                    for (WfInstanceStep wfInstanceStep : wfInstanceSteps) {
                        WfInstanceUser userContdition = new WfInstanceUser();
                        userContdition.setStepId(wfInstanceStep.getStepId());
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
    public void updateWorkFlowProcess(WfInstance instance) {

        //判断流程状态    为待审批
        WfInstance wfInstance = wfInstanceMapper.selectByPrimaryKey(instance.getInstanceId());
        if (wfInstance.getStatus() != WorkFlowConstance.NOT_APPROVE) {
            //TODO 可以修改
//            throw new Exception();
        }
        //删除实例下的步骤和用户信息
        WfInstanceStep stepCondition = new WfInstanceStep();
        stepCondition.setInstanceId(instance.getInstanceId());
        List<WfInstanceStep> wfInstanceSteps = wfInstanceStepMapper.selectBySelective(stepCondition);
        if (null != wfInstanceSteps && wfInstanceSteps.size() > 0) {
            for (WfInstanceStep wfInstanceStep : wfInstanceSteps) {
                //
                WfInstanceUser userConditon = new WfInstanceUser();
                userConditon.setStepId(wfInstanceStep.getStepId());
                List<WfInstanceUser> wfInstanceUsers = wfInstanceUserMapper.selectBySelective(userConditon);
                if (null != wfInstanceUsers && wfInstanceUsers.size() > 0) {
                    //循环删除实例用户信息
                    for (WfInstanceUser wfInstanceUser : wfInstanceUsers) {
                        wfInstanceUserMapper.deleteByPrimaryKey(wfInstanceUser.getId());
                    }
                    wfInstanceStepMapper.deleteByPrimaryKey(wfInstanceStep.getStepId());
                } else {
                    //步骤没有用户信息，做删除
                    wfInstanceStepMapper.deleteByPrimaryKey(wfInstanceStep.getStepId());
                }
            }
        }
        //重新插入实例步骤和用户信息
        autoApprove(instance);
        //
    }

    /**
     * 审批任务移接给他人
     */
    @Override
    public void changeApproveUser(Long id, String handleId, String handleName) {
        WfInstanceUser wfInstanceUser = new WfInstanceUser();
        wfInstanceUser.setId(id);
        wfInstanceUser.setHandlerId(handleId);
        wfInstanceUser.setHandlerName(handleName);
        wfInstanceUserMapper.updateByPrimaryKeySelective(wfInstanceUser);
    }

    /**
     * 取消审批流程
     */
    @Override
    public void cancelWorkFlow() {


    }

    /**
     * 驳回审批
     */
    public void rebutApprove() {

    }


}
