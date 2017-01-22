package com.t2cloud.service.impl;

import com.t2cloud.mapper.WfTempMapper;
import com.t2cloud.mapper.WfTempStepMapper;
import com.t2cloud.mapper.WfTempUserMapper;
import com.t2cloud.mapper.WfTypeMapper;
import com.t2cloud.pojo.WfTemp;
import com.t2cloud.pojo.WfTempStep;
import com.t2cloud.pojo.WfTempUser;
import com.t2cloud.service.WorkflowDefinationService;
import com.t2cloud.util.WorkFlowConstance;
import com.t2cloud.vo.WorkFlowForCreat;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: why
 * Date: 2017/1/9
 * Time: 13:36
 * 流程定义实现类
 */
@Service(value = "workflowDefinationService")
public class WorkflowDefinationServiceImpl implements WorkflowDefinationService {

    @Resource
    private WfTempMapper wfTempMapper;
    @Resource
    private WfTempStepMapper wfTempStepMapper;
    @Resource
    private WfTempUserMapper wfTempUserMapper;
    @Resource
    private WfTypeMapper wfTypeMapper;


    /**
     * 添加流程审核信息
     *
     * @param
     */
    @Override
    public void insertWorkFlow(WorkFlowForCreat flowForCreat) {
        //插入流程模版信息
        WfTemp wfTemp = new WfTemp();
        wfTemp.setName(flowForCreat.getName());
        wfTemp.setUse(flowForCreat.getEnable());
        wfTemp.setPostUserId(flowForCreat.getCreateId());
        wfTemp.setPostTimestamp(new Date());
        wfTemp.setTypeId(flowForCreat.getCategoryId());
        if (flowForCreat.getEnable()) {
            wfTemp.setStatus(WorkFlowConstance.DEPLOY);
        } else {
            wfTemp.setStatus(WorkFlowConstance.NEWCREATE);
        }
        wfTempMapper.insert(wfTemp);

        //插入步骤和审批人信息  TODO 待修改
        List<WorkFlowForCreat.Step> steps = flowForCreat.getSteps();
        if (null != steps && steps.size() > 0) {
            WfTempStep wfTempStep = null;
            WfTempUser wfTempUser = null;
            int mode = 0;
            for (WorkFlowForCreat.Step step : steps) {
                wfTempStep = new WfTempStep();
                //设置流程id
                wfTempStep.setTempId(wfTemp.getTempId());
                wfTempStep.setName(step.getStepName());
                wfTempStep.setOrderNo(++mode);
                if (step.equals(steps.get(steps.size() - 1))) {
                    wfTempStep.setLast(true);
                } else {
                    wfTempStep.setLast(false);
                }
                wfTempStepMapper.insert(wfTempStep);
                //插入用户信息
                wfTempUser = new WfTempUser();
                wfTempUser.setstepId(wfTempStep.getStepId());
                wfTempUser.setHandlerName(step.getName());
                wfTempUser.setHandlerId(step.getDealuser());
                wfTempUserMapper.insert(wfTempUser);
            }
        }
    }

    @Override
    public List<WfTemp> list() {
        return getWfTemps(null);
    }

    /**
     * 获取模版列表信息或单个列表详情
     *
     * @param temp
     * @return
     */
    private List<WfTemp> getWfTemps(WfTemp temp) {
        //查询所有，模版
        List<WfTemp> wfTemps = wfTempMapper.list(temp);
        if (null != wfTemps && wfTemps.size() > 0) {
            List<WfTempStep> wfTempSteps = null;
            for (WfTemp wfTemp : wfTemps) {
                //设置流程类别名字
                wfTemp.setCategory(wfTypeMapper.selectByPrimaryKey(wfTemp.getTypeId()).getName());
                wfTempSteps = wfTempStepMapper.selectByTempId(wfTemp.getTempId());
                //步骤审批人信息
                if (null != wfTempSteps && wfTempSteps.size() > 0) {
                    wfTemp.setWfTempStepList(wfTempSteps);
                    List<WfTempUser> wfTempUsers = null;
                    for (WfTempStep wfTempStep : wfTempSteps) {
                        wfTempUsers = wfTempUserMapper.selectByStepId(wfTempStep.getStepId());
                        if (null != wfTempUsers && wfTempUsers.size() > 0) {
                            wfTempStep.setTempUsers(wfTempUsers);
                        }
                    }
                }
            }
        }
        return wfTemps;
    }

    private List<WfTemp> deleteWfTemps(WfTemp temp) {
        //查询所有，模版
        List<WfTemp> wfTemps = wfTempMapper.list(temp);
        if (null != wfTemps && wfTemps.size() > 0) {
            List<WfTempStep> wfTempSteps = null;
            for (WfTemp wfTemp : wfTemps) {
                wfTempSteps = wfTempStepMapper.selectByTempId(wfTemp.getTempId());
                //步骤审批人信息
                if (null != wfTempSteps && wfTempSteps.size() > 0) {
                    List<WfTempUser> wfTempUsers = null;
                    for (WfTempStep wfTempStep : wfTempSteps) {
                        wfTempUsers = wfTempUserMapper.selectByStepId(wfTempStep.getStepId());
                        if (null != wfTempUsers && wfTempUsers.size() > 0) {
                            for (WfTempUser wfTempUser : wfTempUsers) {
                                //删除模版用户信息
                                wfTempUserMapper.deleteByPrimaryKey(wfTempUser.getid());
                            }
                            //删除步骤信息
                            wfTempStepMapper.deleteByPrimaryKey(wfTempStep.getStepId());
                        } else {
                            //删除步骤信息
                            wfTempStepMapper.deleteByPrimaryKey(wfTempStep.getStepId());
                        }
                    }
                    //删除模版
                    wfTempMapper.deleteByPrimaryKey(wfTemp.getTempId());
                }
            }
        }
        return wfTemps;
    }

    /**
     * 修改流程
     *
     * @param flowForCreat
     * @throws Exception
     */
    @Override
    public void update(Long id, WorkFlowForCreat flowForCreat) {


    }

    /**
     * 删除模版
     *
     * @param tempIds
     */
    @Override
    public void delete(Long[] tempIds) {
        //TODO 硬删除  or  软删除 删除流程要判读有没有流程实例正在运行，否则不能删除  模版不能删除
        //根据流程模版查找流程步骤，删除流程步骤下的变量，在删除流程步骤，在删除流程
        for (Long tempId : tempIds) {
            WfTemp wfTemp = new WfTemp();
            wfTemp.setTempId(tempId);
            deleteWfTemps(wfTemp);
        }
    }

    /**
     * 流程模版详情
     */
    @Override
    public WfTemp show(Long tempId) {
        WfTemp wfTemp = new WfTemp();
        wfTemp.setTempId(tempId);
        return getWfTemps(wfTemp).get(0);
    }

    /**
     * 修改流程状态
     *
     * @param enabled
     */
    @Override
    public void updateStatus(Long id,boolean enabled) {
        WfTemp wfTemp = new WfTemp();
        wfTemp.setTempId(id);
        wfTemp.setUse(enabled);
        wfTempMapper.updateByPrimaryKeySelective(wfTemp);
    }
}
