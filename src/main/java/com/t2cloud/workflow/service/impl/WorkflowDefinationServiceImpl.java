package com.t2cloud.workflow.service.impl;

import com.t2cloud.workflow.mapper.WfTempMapper;
import com.t2cloud.workflow.mapper.WfTempStepMapper;
import com.t2cloud.workflow.mapper.WfTempUserMapper;
import com.t2cloud.workflow.pojo.*;
import com.t2cloud.workflow.service.WorkflowDefinationService;
import com.t2cloud.workflow.vo.WorkFlowDefination;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: why
 * Date: 2017/1/9
 * Time: 13:36
 * 流程定义实现类
 */
@Service
public class WorkflowDefinationServiceImpl implements WorkflowDefinationService {

    @Resource
    private WfTempMapper wfTempMapper;
    @Resource
    private WfTempStepMapper wfTempStepMapper;
    @Resource
    private WfTempUserMapper wfTempUserMapper;


    /**
     * 添加流程审核信息
     *
     * @param
     */
    @Override
    public void insertWorkFlow(WfTemp wfTemp) {
        //插入流程模版信息
        wfTempMapper.insert(wfTemp);
    }

    @Override
    public void insertWorkFlowStep(Long workFlowId, WfTempStep wfTempStep, WfTempUser wfTempUser) {
        //设置流程id
        wfTempStep.setTempId(workFlowId);
        wfTempStepMapper.insert(wfTempStep);
        if (null != wfTempUser) {
            //插入步骤审批信息
            wfTempUser.setstepId(wfTempStep.getStepId());
            wfTempUserMapper.insert(wfTempUser);
        }
    }


    @Override
    public void list() {
        //查询模版、步骤、变量进行拼装 存入session
        //TODO 列表sql 分2个条件  1管理员和普通用户 2是否为模版
//        SELECT * FROM wf_temp _temp,wf_temp_step _step,wf_temp_user _tuser
//        WHERE
//        _temp.temp_id=_step.temp_id
//        AND
//        _step.step_id=_tuser.step_id;


    }

    @Override
    public void update(WorkFlowDefination flowDefination) throws Exception {
        //判断模版是不是模版 维护session里的信息
        if (flowDefination.getWfTemp().getIsmodel() == 0) {
            throw new Exception("模版不提供修改功能");
        }
        //TODO 待修改
        //temp修改字段
        wfTempMapper.updateByPrimaryKeySelective(flowDefination.getWfTemp());
        //修改步骤字段
        wfTempStepMapper.updateByPrimaryKeySelective(flowDefination.getWfTempStep().get(0));
        //修改步骤变量字段
        wfTempUserMapper.updateByPrimaryKeySelective(flowDefination.getWfTempUser().get(0));

    }

    @Override
    public void delete(String tempId) {
        //维护session里的流程模版
        //TODO 删除流程要判读有没有流程实例正在运行，否则不能删除

        //根据流程模版查找流程步骤，删除流程步骤下的变量，在删除流程步骤，在删除流程
    }


}
