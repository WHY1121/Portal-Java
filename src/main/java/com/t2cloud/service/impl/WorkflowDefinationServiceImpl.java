package com.t2cloud.service.impl;

import com.t2cloud.mapper.WfTempMapper;
import com.t2cloud.mapper.WfTempStepMapper;
import com.t2cloud.mapper.WfTempUserMapper;
import com.t2cloud.pojo.WfTemp;
import com.t2cloud.pojo.WfTempStep;
import com.t2cloud.pojo.WfTempUser;
import com.t2cloud.service.WorkflowDefinationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        //TODO 最后一步,修改流程状态为可用
        WfTemp wfTemp=new WfTemp();
        wfTemp.setTempId(workFlowId);
        wfTemp.setUse(true);
        wfTempMapper.updateByPrimaryKeySelective(wfTemp);

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
     * @param wfTemp
     * @param wfTempStep
     * @param wfTempUser
     * @throws Exception
     */
    @Override
    public void update(WfTemp wfTemp, WfTempStep wfTempStep, WfTempUser wfTempUser) throws Exception {
        //判断模版是不是模版 维护session里的信息
        if (null != wfTemp) {
            //temp修改字段
            wfTempMapper.updateByPrimaryKeySelective(wfTemp);
        }
        if (null != wfTempStep) {
            //修改步骤字段
            wfTempStepMapper.updateByPrimaryKeySelective(wfTempStep);
        }
        if (null != wfTempUser) {
            //修改步骤变量字段
            wfTempUserMapper.updateByPrimaryKeySelective(wfTempUser);
        }
    }

    /**
     * 删除模版
     * @param tempId
     */
    @Override
    public void delete(Long tempId) {
        //TODO 硬删除  or  软删除 删除流程要判读有没有流程实例正在运行，否则不能删除  模版不能删除
        //根据流程模版查找流程步骤，删除流程步骤下的变量，在删除流程步骤，在删除流程
        WfTemp wfTemp = new WfTemp();
        wfTemp.setTempId(tempId);
        deleteWfTemps(wfTemp);
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
}
