package com.t2cloud.service.impl;

import com.t2cloud.mapper.WfTempMapper;
import com.t2cloud.mapper.WfTempStepMapper;
import com.t2cloud.mapper.WfTempUserMapper;
import com.t2cloud.pojo.WfTemp;
import com.t2cloud.pojo.WfTempStep;
import com.t2cloud.pojo.WfTempUser;
import com.t2cloud.service.WorkflowDefinationService;
import com.t2cloud.vo.WorkFlowDefination;
import org.springframework.stereotype.Service;

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

        //查询所有，模版
        List<WfTemp> wfTemps = wfTempMapper.list();
        //TODO 步骤信息
        if (null != wfTemps && wfTemps.size() > 0) {
            for (WfTemp wfTemp : wfTemps) {
                List<WfTempStep> wfTempSteps = wfTempStepMapper.selectByTempId(wfTemp.getTempId());
                //步骤审批人信息
                if (null != wfTempSteps && wfTempSteps.size() > 0) {
                    for (WfTempStep wfTempStep : wfTempSteps) {
                        List<WfTempUser> wfTempUsers = wfTempUserMapper.selectByStepId(wfTempStep.getStepId());
                    }
                }
            }
        }

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
//         wfTempUserMapper.deleteByPrimaryKey();
        //根据流程模版查找流程步骤，删除流程步骤下的变量，在删除流程步骤，在删除流程
    }

    /**
     * 流程模版详情
     */
    @Override
    public WfTemp show(Long tempId) {
        //TODO
        WfTemp wfTemp = wfTempMapper.selectByPrimaryKey(tempId);
        if (null != wfTemp) {
            List<WfTempStep> wfTempSteps = wfTempStepMapper.selectByTempId(tempId);
            if (null != wfTempSteps && wfTempSteps.size() > 0) {
                wfTemp.setWfTempStepList(wfTempSteps);
                for (WfTempStep wfTempStep : wfTempSteps) {
                    List<WfTempUser> wfTempUsers = wfTempUserMapper.selectByStepId(wfTempStep.getStepId());
                    if (null != wfTempUsers && wfTempUsers.size() > 0) {
                        wfTempStep.setTempUsers(wfTempUsers);
                    }
                }
            }
        }
       return wfTemp;
    }


}
