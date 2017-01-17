package com.t2cloud.workflow.service;

import com.t2cloud.workflow.pojo.WfTemp;
import com.t2cloud.workflow.pojo.WfTempStep;
import com.t2cloud.workflow.pojo.WfTempUser;
import com.t2cloud.workflow.vo.WorkFlowDefination;

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

    void list();

    void update(WorkFlowDefination flowDefination) throws Exception;

    void delete(String tempId);


}
