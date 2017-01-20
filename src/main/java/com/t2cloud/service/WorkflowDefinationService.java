package com.t2cloud.service;

import com.t2cloud.pojo.WfTemp;
import com.t2cloud.pojo.WfTempUser;
import com.t2cloud.pojo.WfTempStep;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/9
 * Time: 17:14
 */
public interface WorkflowDefinationService {

    /**
     *   定义模版
     */
    void insertWorkFlow(WfTemp wfTemp);

    /**
     * 定义步骤
     */
    void insertWorkFlowStep(Long workFlowId, WfTempStep wfTempStep,WfTempUser wfTempUser);

    List<WfTemp> list();

    void update(WfTemp wfTemp,WfTempStep wfTempStep,WfTempUser wfTempUser) throws Exception;

    void delete(Long tempId);

    /**
     * 查询模版详情
     * @param tempId
     * @return
     */
    WfTemp show(Long tempId);


}
